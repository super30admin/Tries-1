//TC:O(N*K) where k is the length of longest word
//sc:O(K*26)

class Trie {

    /** Initialize your data structure here. */
    class TrieNode
    {
       boolean isWord;
       TrieNode[] child; 
        
       private TrieNode()
       {
           this.isWord = false;
           this.child = new TrieNode[26]; 
       }
    
        
    }
    
    TrieNode root;

    public Trie()
    {
      root= new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
       TrieNode node =  root; 
       for(int i=0;i<word.length();i++)
       {
         char ch = word.charAt(i);
         if(node.child[ch-'a']==null)
             node.child[ch-'a']=new TrieNode();
           
         node =  node.child[ch-'a']; 
       }
        
      node.isWord=true;  
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) 
    {
        TrieNode node = root;
        
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(node.child[ch-'a']==null)
                return false;
            
            node = node.child[ch-'a'];
        }
        
        return node.isWord;
        
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix)
    {
        TrieNode node = root;
        
        for(int i=0;i<prefix.length();i++)
        {
           char ch = prefix.charAt(i); 
           if(node.child[ch-'a']==null)
               return false; 
            node=node.child[ch-'a'];
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