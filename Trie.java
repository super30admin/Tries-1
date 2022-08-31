public class Trie {
    TrieNode root;
   
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        // //O(1)  No auxiliary Data Structure created
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a']==null)
            {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr= curr.children[ch - 'a'];           
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        //O(1)  No auxiliary Data Structure created
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
             char ch = word.charAt(i);
             if(curr.children[ch - 'a']==null)
                 return false;
            curr= curr.children[ch - 'a'];
            
        } 
        
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
       //O(1)  No auxiliary Data Structure created
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++)
        {
             char ch = prefix.charAt(i);
             if(curr.children[ch - 'a']==null)
                 return false;
            curr= curr.children[ch - 'a'];
            
        } 
        
        return true;
    }
}
