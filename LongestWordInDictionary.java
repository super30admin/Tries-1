/**

Leetcode: https://leetcode.com/problems/longest-word-in-dictionary/

720. Longest Word in Dictionary

Collabedit: http://collabedit.com/h7g4q

Time Complexity : O(N)
Space Complexity : O(N*N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution 
{
    public String longestWord(String[] words)
    {
        TrieDataStructure trie = new TrieDataStructure();
        String output = "";
        
        for( String word : words)
        {
            trie.insert(word);
        }
        
        TrieNode root = trie.getRoot();
        
        Queue<TrieNode> queue = new LinkedList<>();
        
        queue.add( root);
        
        TrieNode current = null; 
        
        while ( !queue.isEmpty() )
        {
            int size = queue.size();
            int lastChild = size;
            
            for( int i =0 ;i < size; i++)
            {
                current = queue.poll();
                
                TrieNode children[] = current.children;
                
                
                for( int index = 25; index >= 0; index--)
                {
                    if( children[index] != null && children[index].word != null)
                    {
                        queue.add(children[index]);
                    }
                }
            }
        }
        
        
        return current.word;
    }
    
}

class TrieNode
{
    public String word;
    public TrieNode children[];
    
    public TrieNode()
    {
        this.children = new TrieNode[26];
    }
}
class TrieDataStructure
{
    private TrieNode root;
    
    public TrieDataStructure()
    {
        this.root = new TrieNode();
    }
    
    public void insert( String word)
    {
        TrieNode current = this.root;
        
        for( int i=0; i< word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            
            if(current.children[index] == null)
            {
                current.children[index] = new TrieNode();
            }
        
            current = current.children[index];
        }
        
        current.word = word;
    }
    
    public TrieNode getRoot()
    {
        return this.root;
    }
    
}