// Time Complexity :O(n) for all the function
// Space Complexity : O(mx26) where m is the length of largest word in dictionary
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class TrieNode{
    TrieNode[] children;
    boolean isWord;
    TrieNode()
    {
        isWord= false;
        children = new TrieNode[26];
    }
}
class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        
        root = new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode Node = root;
        for(char c:word.toCharArray())
        {
            if(Node.children[c-'a']==null)
            {
               Node.children[c-'a'] = new TrieNode();
            }
            Node = Node.children[c-'a'];
        }
        Node.isWord= true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode Node = root;
        for(char c:word.toCharArray())
        {
            if(Node.children[c-'a']==null)
            {
               return false;
            }
            Node = Node.children[c-'a'];
        }
        if(Node.isWord)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode Node = root;
        for(char c:prefix.toCharArray())
        {
            if(Node.children[c-'a']==null)
            {
               return false;
            }
            Node = Node.children[c-'a'];
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