// 208. Implement Trie (Prefix Tree) - https://leetcode.com/problems/implement-trie-prefix-tree/

// Time Complexity : 
    //insert: O(L) [length of the longest string]
    //search: O(L) [length of the longest string]
    //prefix: O(P) [length of the prefix string]
// Space Complexity : 
    //insert: O(1) 
    //search: O(1) 
    //prefix: O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Trie {
    
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode(){
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
        TrieNode curr = root;
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            //if letter doesn't exist, then create a node
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();
            //if letter exists, then move curr to children
            curr = curr.children[c-'a'];
        }
        //set the end letter node to true
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length();i++){
            char c = word.charAt(i);
            //if the letter doesn't exist, return false
            if(curr.children[c-'a'] == null)
                return false;
            //if letter exists, then move curr to next node
            curr = curr.children[c-'a'];
        }
        return curr.isEnd; // bcz it may be just prefix and not a word
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            //if letter doesn't exist
            if(curr.children[c-'a'] == null)
                return false;
            //if letter exist, move the curr to next node
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