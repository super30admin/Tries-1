// Time Complexity : building Trie will take n*k
// Space Complexity : 
// Did this code successfully run on GeeksforGeeks : yes
// Any problem you faced while coding this : not sure about time and space complexity


// Your code here along with comments explaining your approach


class Trie {

    class TrieNode {
        
        TrieNode[] children ;
        Boolean isEnd;
        char c;
        public TrieNode()
        {
            children = new TrieNode[26];
            this.isEnd = false;
        }
    }
    TrieNode root;
    public Trie()
    {
       root = new  TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        
        for( int i =0; i < word.length(); i++ )
        {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
   
        for(int i =0 ; i < word.length(); i++ )
        {  
            char c = word.charAt(i);
          if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        
        
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
       TrieNode curr = root;
     
        for(int i =0 ; i < prefix.length(); i++ )
        {
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