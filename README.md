# Tries-1

## Problem1 
Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)

## Time Complexity : O(L)
## Space Complexity : O(L)
class Trie {
    
    class TrieNode{
        boolean isEnd; 
        TrieNode[] children; 
        
        public TrieNode() {
            children = new TrieNode[26]; 
        }
    }

    TrieNode root; 
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(); 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode(); 
            }
            curr = curr.children[c-'a']; 
        }
        curr.isEnd = true; 
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i); 
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return curr.isEnd; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i); 
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
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



## Problem2
Replace Words (https://leetcode.com/problems/replace-words/)
## Time Complexity : O(Nk) + O(L)
## Space Complexity : O(Nk)
class Solution {
    class TrieNode{
        boolean isEnd; 
        TrieNode[] children; 
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public void insert(String word){
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i); 
            
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a']; 
        }
        curr.isEnd = true; 
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
         root = new TrieNode(); 
        
        for(String s: dictionary){
            insert(s); 
        }
        
        String[] splitArr = sentence.split("\\s+"); 
        
        StringBuilder result = new StringBuilder(); 
        
        for(int i = 0; i < splitArr.length; i++){
            String word = splitArr[i];

            if(i > 0) result.append(" "); 
            
            StringBuilder replacement = new StringBuilder(); 
             
            TrieNode curr = root; 
            
            for(int k = 0; k < word.length(); k++){
                char c = word.charAt(k);
                if(curr.children[c-'a'] == null || curr.isEnd) break; 
                curr = curr.children[c-'a']; 
                replacement.append(c); 
            }
            if(curr.isEnd){
                result.append(replacement); 
            }else{
                result.append(word); 
            }
        }
        return result.toString(); 
    }
}
