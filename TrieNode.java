// Time Complexity :O(nl) n is the number of words and l is the length of the words;
// Space Complexity :O(l) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Trie {

    /** Initialize your data structure here. */
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
        
    }
    TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    
    
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i<word.length();i++){
            if(curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        
        curr.isEnd = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i<word.length();i++){
            if(curr.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        
        if(curr.isEnd) return true;
        else return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i<prefix.length();i++){
            if(curr.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            curr = curr.children[prefix.charAt(i) - 'a'];
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