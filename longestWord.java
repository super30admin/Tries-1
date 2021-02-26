// Time Complexity : O(n) n is no of keys
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class Solution {
    public String longestWord(String[] words) {
        
        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }
        
        return trie.longestWord();
    }
}

class TrieNode {
    
    String word;
    HashMap<Character, TrieNode> childrens;
    
    public TrieNode() {
        childrens = new HashMap(26);
        word = "";
    }
    
}

class Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    String lWord = "";
    
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            
            if(!curr.childrens.containsKey(c)) {
                curr.childrens.put(c, new TrieNode());
            }
            curr = curr.childrens.get(c);
            
        }
        curr.word = word;
        
    }
    
    public String longestWord() {
        
        dfs(root);
            
        return lWord;
        
    }
    
    public void dfs(TrieNode curr) {
        
        if(curr.word.length() > lWord.length()) {
            lWord = curr.word;
        }
        
        for(TrieNode t : curr.childrens.values()) {
            
            if(!t.word.equals("")) {
                dfs(t);
            }
            
            
        }
    }
    
}
