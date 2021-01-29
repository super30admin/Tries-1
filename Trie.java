// Time Complexity : The time complexity is O(sum of lengths of all the strings)
// Space Complexity : The space complexity is O(sum of lengths of all the strings)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Trie {

    Node root;

    /** Initialize your data structure here. */
    public Trie() {

        root = new Node();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        int len = word.length();
        Node cur = root;
        int i=0;

        // Insert each letter in the trie
        while(i < len){

            char ch = word.charAt(i);

            if(cur.children[ch-'a'] == null){
                cur.children[ch-'a'] = new Node();
            }
            cur = cur.children[ch-'a'];
            i++;
        }

        cur.isEnd = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        int len = word.length();
        Node cur = root;
        int i=0;

        // Traverse through the length of the word and check if it exists
        while(i < len){

            char ch = word.charAt(i);

            if(cur.children[ch-'a'] == null){
                return false;
            }
            cur = cur.children[ch-'a'];
            i++;
        }

        return cur.isEnd;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        int len = prefix.length();
        Node cur = root;
        int i=0;

        // Traverse through the length of the word and check if it exists
        while(i < len){

            char ch = prefix.charAt(i);

            if(cur.children[ch-'a'] == null){
                return false;
            }
            cur = cur.children[ch-'a'];
            i++;
        }

        return true;
    }
}

class Node{

    boolean isEnd;
    Node[] children;

    public Node(){
        children = new Node[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */