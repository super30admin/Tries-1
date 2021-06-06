//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Trie {
    
    class TrieNode{
        
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode(){
            
            this.children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    
    /** Initialize your data structure here. */
    public Trie() {
        
        root = new TrieNode();
        //root.isEnd = new boolean();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i ++){
            
            char ch = word.charAt(i);
            
            if(curr.children[ch - 'a'] == null){//children doesnt contain the character of the word
                
                //curr.children[ch - 'a'] = new ; /////doubt
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        
        curr.isEnd = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i ++){
            
            char ch = word.charAt(i);
            
            if(curr.children[ch - 'a'] == null){//children doesnt contain the character of the word
                
                //curr.children[ch - 'a'] = new int[26]; /////doubt
                //curr.children[ch - 'a'] = new TrieNode();
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        
      return curr.isEnd;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode curr = root;
        
        for(int i = 0; i < prefix.length(); i ++){
            
            char ch = prefix.charAt(i);
            
            if(curr.children[ch - 'a'] == null){//children doesnt contain the character of the word
                
                //curr.children[ch - 'a'] = new int[26]; /////doubt
                //curr.children[ch - 'a'] = new TrieNode();
                return false;
            }
            curr = curr.children[ch - 'a'];
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