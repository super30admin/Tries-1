/**
// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
 */
class Trie {
    class Node{
        char ch;
        Node child[];
        Boolean isLast;

        Node(char ch, boolean last){
            this.child = new Node[26];
            this.ch = ch;
            this.isLast = last;
        }
    }

    Node head;

    /** Initialize your data structure here. */
    public Trie() {
        head = new Node(' ', false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int indx = 0;
        Node node = head;
        while(indx < word.length()){
            char letter = word.charAt(indx++);
            Node cnode = node.child[letter - 'a'];

            if(cnode == null){// char does not exist.
                cnode = new Node(letter, false);
                node.child[letter-'a'] = cnode;
            }
            node = cnode;
        }
        node.isLast = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = head;
        int indx = 0;
        while(indx < word.length()){
            char letter = word.charAt(indx++);
            Node cnode = node.child[letter - 'a'];
            if(cnode == null)
                return false;
            node = cnode;
        }
        if(node.isLast)
            return true;

        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = head;
        int indx = 0;
        while(indx < prefix.length()){
            char letter = prefix.charAt(indx++);
            Node cnode = node.child[letter-'a'];
            if(cnode == null)
                return false;
            node = cnode;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
