class Trie {
    
    class TrieNode { 
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }
    
    TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode curr = root;
        
        //go through each prefix characters
        for(int i = 0; i < word.length(); ++i)
        {
            if(curr.children[word.charAt(i) - 'a'] == null)
                curr.children[word.charAt(i)- 'a'] = new TrieNode();
            
            curr = curr.children[word.charAt(i) - 'a'];
        }
        
        curr.isEnd = true;
        return;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        //Initiate Root
        TrieNode node = root;
        
        for(int i = 0; i < word.length(); ++i)
        { 
            if(node.children[word.charAt(i) - 'a'] == null) return false;
            
            node = node.children[word.charAt(i) - 'a'];
        }
        
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        //Initiate Trie
        TrieNode curr = root;
        
        for(int i= 0 ; i < prefix.length(); ++i)
        {
            if(curr.children[prefix.charAt(i)- 'a'] == null) return false;
            
            curr = curr.children[prefix.charAt(i) - 'a'];
        }
        
        return true;
    }
}
