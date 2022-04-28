// Time Complexity : O(w) where w is word length
// Space Complexity : O(w) where w is word length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class Solution {
    
    public String replaceWords(List<String> rootWords, String sentence) {
        
        Trie trie = new Trie();
        
        for (String rootWord : rootWords) {
            trie.insert(rootWord);
        }
        
        String[] words = sentence.split(" "); // splitting by spaces
        
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            
            if (result.length() > 0) {
                result.append(" ");
            }
            
            String prefixWord = trie.getPrefixWord(word);
            
            if (prefixWord == null) {
                result.append(word);
            }
            else {
                result.append(prefixWord);
            }
        }
        return result.toString();
    }
}

class TrieNode {
    TrieNode[] children;
    boolean end;
    
    public TrieNode() {
        this.children = new TrieNode[26];
        this.end = false;
    }
}

class Trie {

    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public String getPrefixWord(String word) {
        
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
                        
            if (node.end) {
                return word.substring(0, i);
            }
            
            char c = word.charAt(i);
            
            if (node.children[c - 'a'] == null) {
                return null;                    
            }
            
            node = node.children[c - 'a'];
        }
        
        if (node.end) {
            return word;
        }
        return null;
    }
    
    public void insert(String word) {
        
        TrieNode curr = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            
            curr = curr.children[c - 'a'];
        }
        
        curr.end = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            
            curr = curr.children[c - 'a'];
        }
        
        return curr.end;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            
            curr = curr.children[c - 'a'];
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
