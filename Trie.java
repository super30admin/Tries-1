// Time Complexity: O(n) where n is length of string
// Space Complexity :O(n*26) for each character we have an array of 26 length and one bool variable

public class Trie {
    TrieNode root;
    
    public class TrieNode {
        TrieNode [] children;
        boolean isEnd;
        
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }
    
    public Trie()
    {
        root = new TrieNode();
    }
    
    // Time Complexity: (n) where n is length of word
    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(curr.children[c-'a'] == null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a']; // update curr to next root 
        }
        // end of the word as is End
        curr.isEnd = true;
    }
    
    // Time Complexity: O(n) where n is length of word
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
             if(curr.children[c-'a'] == null)
             {
                 return false;
             }
             curr = curr.children[c-'a']; // move to next char
        }
        
        return curr.isEnd; // will be true if it is the end of word looking for
    }
    
    // Time Complexity: O(n) where n is length of prefix
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c :  prefix.toCharArray())
        {
            if(curr.children[c-'a'] == null)
            {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true; // since we do not want entire word
    }
}