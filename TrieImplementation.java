// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Trie {
    
    class TrieNode{
        boolean isWordPresent;
        TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode currentPtr = root;
        
        for(int i=0;i<word.length();i++){
            char currChar = word.charAt(i);
            
            if(currentPtr.children[currChar-'a']==null){
                currentPtr.children[currChar-'a']=new TrieNode();
            }
            currentPtr = currentPtr.children[currChar-'a'];
        }
        
        currentPtr.isWordPresent = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode currentPtr = root;
        
        for(int i=0;i<word.length();i++){
            char currChar = word.charAt(i);
            
            if(currentPtr.children[currChar-'a']==null)return false;
            
            currentPtr = currentPtr.children[currChar-'a'];
        }
        
        return currentPtr.isWordPresent;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode currentPtr = root;
        
        for(int i=0;i<prefix.length();i++){
            char currChar = prefix.charAt(i);
            
            if(currentPtr.children[currChar-'a']==null)return false;
            
            currentPtr = currentPtr.children[currChar-'a'];
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
