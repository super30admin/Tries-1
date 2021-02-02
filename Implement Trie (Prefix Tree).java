// Time Complexity : O(m) for all operations where m is the length of the word
// Space Complexity : O(m) for insertion and O(1) for everything else
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Trie {
    class TrieNode{
        //need a boolean
        boolean isEnd;
        //children array
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
        //take the current 
        TrieNode cur = root;
        //start iterating through the word
        for(int i = 0; i < word.length(); i++){
            //take a single character
            char c = word.charAt(i);
            //check if the children array is null or not
            //if null add a trie node
            if(cur.children[c - 'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }
            //keep moving the cur pointer
            cur = cur.children[c-'a'];
        }
        //mark the end of the word by chaning isEnd to true
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        //take the current 
        TrieNode cur = root;
        //start iterating through the word
        for(int i = 0; i < word.length(); i++){
            //take a single character
            char c = word.charAt(i);
            //check if the children array is null or not
            //if null add a trie node
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
            //if null add a trie node
            if(cur.children[c - 'a'] == null){
                return false;
            }
            //keep moving the cur pointer
            cur = cur.children[c-'a'];
        }
        //return true which will say if we have found the end of the prefix
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


