// Time Complexity : O(m)
// Space Complexity : O(m) for insert, O(1) all others
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Trie {
    class TrieNode{
        //boolean
        boolean isEnd;
        //children
        TrieNode [] children;
        public TrieNode(){
            //only lowercase letters
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        //current
        TrieNode cur = root;
        //start iterating through the word
        for(int i = 0; i < word.length(); i++){
            //take a single character
            char c = word.charAt(i);
            //check if the children array is null or not
            //add a trie node if null
            if(cur.children[c - 'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }

            cur = cur.children[c-'a'];
        }
        //mark the end of word
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        //start iterating through the word
        for(int i = 0; i < word.length(); i++){

            char c = word.charAt(i);
            //check if the children array is null or not
            if(cur.children[c - 'a'] == null){
                return false;
            }
            //keep moving the cur pointer
            cur = cur.children[c-'a'];
        }
        //return the isEnd which will say if we have found the end of the word
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        //take the current
        TrieNode cur = root;
        //start iterating through the word
        for(int i = 0; i < prefix.length(); i++){
            //take a single character
            char c = prefix.charAt(i);
            //check if the children array is null or not

            if(cur.children[c - 'a'] == null){
                return false;
            }
            //keep moving the cur pointer
            cur = cur.children[c-'a'];
        }
        //if found the end of the prefix
        return true;

    }
}