class Trie 
{
    TrieNode start = new TrieNode();

    public Trie() {
        
    }
    
    public void insert(String word) 
    {
        TrieNode current = start;
        for(int i =0; i< word.length(); i++)
        {
            char val = word.charAt(i);
            int index = val - 'a';
            
            if(current.children[index] == null)
            {
                current.children[index] = new TrieNode();
            }
            
            current = current.children[index];
        }
        
        current.end = true;
    }
    
    public boolean search(String word) 
    {
        TrieNode current = start;
        
        for(int i =0; i< word.length(); i++)
        {
            char val = word.charAt(i);
            int index = val - 'a';
            
            if(current.children[index] == null)
                return false;
            
            current = current.children[index];
        }
        
        return current.end;
        
    }
    
    public boolean startsWith(String prefix) 
    {
        TrieNode current = start;
        for(int i =0; i< prefix.length(); i++)
        {
            char val = prefix.charAt(i);
            int index = val - 'a';
            
            if(current.children[index] == null)
                return false;
            
            current = current.children[index];
        }
        
        return true;
    }
}
class TrieNode
{
    boolean end = false;
    TrieNode children[];
    
    public TrieNode()
    {
        this.children = new TrieNode[26];
    }
    
    public String toString()
    {
        return end + " " + children;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */