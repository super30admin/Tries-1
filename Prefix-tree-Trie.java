class Trie {
    
    class TrieNode{
        boolean isWord;
        TrieNode[] children;
    
      TrieNode(){
          isWord = false;
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
        
        TrieNode node = root;
        
        for (int x = 0; x < word.length(); x++){
            Character ch = word.charAt(x);
            
            if (node.children[ch - 'a'] == null){
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode node = root;
        
        for (int x = 0; x < word.length(); x++){
            Character ch = word.charAt(x);
            
            if (node.children[ch - 'a'] == null){
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return node.isWord;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode node = root;
        
        for (int x = 0; x < prefix.length(); x++){
            Character ch = prefix.charAt(x);
            
            if (node.children[ch - 'a'] == null){
                return false;
            }
            node = node.children[ch - 'a'];
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