//Implement prefix tree
// TC for all operations -> length of word l
class Trie {
    class TrieNode
{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode()
    {
        this.children=new TrieNode[26];
        //isEnd=false 
    }
}
    private TrieNode root;

    public Trie() {

        this.root=new TrieNode();
    }
    
    public void insert(String word) {

        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(curr.children[c-'a']==null)//aplphabet not present in Trie
            {
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];//move to  next child node 
        }
        curr.isEnd=true;

        
        
    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {  
             char c=word.charAt(i);
              if(curr.children[c-'a']==null) return false;
              curr=curr.children[c-'a'];//next node
        }
        return curr.isEnd; //if its an end of string ,then return true else false
        
    }
    
    public boolean startsWith(String prefix) {

        TrieNode curr=root;
         for(int i=0;i<prefix.length();i++)
        {
             char c=prefix.charAt(i);
              if(curr.children[c-'a']==null) return false;
              curr=curr.children[c-'a'];//next node
        }
        //coming out of loop means prefix is present
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