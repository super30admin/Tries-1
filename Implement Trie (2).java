
//Time complexity: O(m), m is key length
//Space complexity: O(m)

class TrieNode
{
    public TrieNode[]children;
    private final int R=26;
    
    public boolean isEnd;
    public TrieNode()
    {
        children=new TrieNode[R];
        
    }
  
}


class Trie {
TrieNode[] children;
    public TrieNode root;
   public boolean isEnd; 
    public Trie() {
        children=new TrieNode[26];
        isEnd=false;
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c= word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a']= new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c= word.charAt(i);
         if(curr.children[c-'a']!=null)
         {
             curr=curr.children[c-'a'];
             continue;
         }
            else
            {
                return false;
            }
        }
        if(curr.isEnd==true)
        return true;
        else
            return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++){
            char c= prefix.charAt(i);
         if(curr.children[c-'a']!=null)
         {
             curr=curr.children[c-'a'];
             continue;
         }
            else
            {
                return false;
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