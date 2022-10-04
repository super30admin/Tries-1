class Trie {
    //tc - o(l) where l is length of the word
    //sc - o(1)
    class TrieNode
    {
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
         char c = word.charAt(i);
            if(curr.children[c-'a'] == null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            
                curr = curr.children[c-'a'];
            
        }
        curr.isEnd = true;
        
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null)  
            {
                return false;
            }
              curr = curr.children[c-'a'];
        }
        return curr.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++)
        {
        char c = prefix.charAt(i);
        if(curr.children[c-'a'] == null)
        {
            return false;
        }
        else
        {
            curr = curr.children[c-'a']; // if searching for bat, if b is there.
            //we will move our current pointer to index of a i.e if we need t then t-'a'
                
        }
             
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