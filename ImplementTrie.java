// Time Complexity :insert,search,startsWith -> O(l) where l is the length of the word
// Space Complexity :insert -> O(l) where l is the length of the word ; search,startsWith -> O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Trie {
  
    class TrieNode
    {
      TrieNode[] children;
      boolean isWord;
      
      public TrieNode()
      {
        children = new TrieNode[26];
        isWord = false; 
      }
    }
  
  TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
      
      root = new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
      
      TrieNode current = root;
      for(char ch:word.toCharArray())
      {
        if(current.children[ch-'a']==null)
        {
          current.children[ch-'a'] = new TrieNode();
        }
        current = current.children[ch-'a'];
      }
        current.isWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      
      TrieNode current = root;
      for(char ch:word.toCharArray())
      {
        if(current.children[ch-'a']==null)
        {
          return false;
        }
        current = current.children[ch-'a'];
      }
       return current.isWord; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      
      TrieNode current = root;
      for(char ch:prefix.toCharArray())
      {
        if(current.children[ch-'a']==null)
        {
          return false;
        }
        current = current.children[ch-'a'];
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