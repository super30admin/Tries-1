//TC: O(w) where w is word length of ALL words
//SC: O(n) for recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    private String ans;
    
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        
        for (String word : words) {
            trie.insert(word);
        }
        
        ans = "";
        
        //dfs
        dfs(trie.root);
        
        return ans;
    }
    
    public void dfs(TrieNode node) {
        
        //base
        if (node == null || node.end == false) {
            return;
        }
        
        if (node.word.length() > ans.length()) {
            ans = node.word;
        }
        
        //recurse
        for (int i = 0; i < 26; i++) {
            dfs(node.children[i]);
        }
    }
}

class Trie {
    TrieNode root;
    
    Trie() {
        root = new TrieNode();
        root.end = true;
        root.word = "";
    }
    
    public void insert(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            
            node = node.children[c - 'a'];
        }
        
        node.end = true;
        node.word = word;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean end;
    String word;
    
    TrieNode() {
        children = new TrieNode[26];
    }
}