// Time Complexity : O(L)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Trie {
    class TrieNode{
        TrieNode [] children;
        boolean isEnd; // initially false
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    
    TrieNode root; 
    /* Initialize your data structure here */
    public Trie(){
        root = new TrieNode();
    }
    // insert a word into Trie
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                // c is not present eg inserting cat and "a" is not present
                curr.children[c-'a'] = new TrieNode();
            } 
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    /* returns if word is in trie*/
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            // not present case:
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }
    
    /*returns if there is a word starting with prefix*/
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0; i< prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
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