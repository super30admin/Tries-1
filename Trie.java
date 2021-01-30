/**

Leetcode: https://leetcode.com/problems/implement-trie-prefix-tree/

Implement a trie with insert, search, and startsWith methods.

Collabedit: http://collabedit.com/u2cm6

Time Complexity : O(N)
Space Complexity : O(N*N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/

class Trie 
{
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) 
    {
        
        TrieNode current = this.root;
        
        for( int i =0; i< word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            
            if( current.children[index] == null)
            {
                current.children[index] = new TrieNode();
            }
            
            current = current.children[index];
        }
        
        current.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) 
    {
        TrieNode current = this.root;
        
        for( int i =0; i< word.length() ; i++)
        {
            int index = word.charAt(i) - 'a';
            
            if( current.children[index] == null)
            {
                return false;
            }
            
            current = current.children[index];
        }
        
       return current.isEnd;        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) 
    {
        TrieNode current = this.root;
        
        for( int i =0; i< prefix.length(); i++)
        {
            int index = prefix.charAt(i) - 'a';
            
            if( current.children[index] == null)
            {
                return false;
            }
            
            current = current.children[index];
        }
        
       return true; 
    }
}
class TrieNode
{
    public boolean isEnd;
    public TrieNode[] children;
    
    public TrieNode()
    {
        this.children = new TrieNode[26];
    }
    
}