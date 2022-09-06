import java.util.LinkedList;
import java.util.Queue;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//208. Implement Trie (Prefix Tree) (Medium) - https://leetcode.com/problems/implement-trie-prefix-tree/
class Trie {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    // Time Complexity : O(n) where n = length of word
    // Space Complexity : O(26 * n) where n = length of word
    public void insert(String word) {
        TrieNode curr = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            
            curr = curr.children[ch - 'a'];
        }
        
        curr.isEnd = true;
    }
    
    // Time Complexity : O(n) where n = length of word
    public boolean search(String word) {
        TrieNode curr = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (curr.children[ch - 'a'] == null) return false;
            curr = curr.children[ch - 'a'];
        }
        
        return curr.isEnd;
    }
    
    // Time Complexity : O(n) where n = length of prefix
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            
            if (curr.children[ch - 'a'] == null) return false;
            curr = curr.children[ch - 'a'];
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