// Longest Word in Dictionary
// solved on leetcode
// Time Complexity : Length of the word
// Space Complexity : Length of the word

class Solution {
   
    
    class TrieNode{
        String word;
        TrieNode [] children;
        
        public TrieNode(){
            children = new TrieNode();
        }
    }
    TrieNode root;
    String result;
    public void insert(String word){
        TrieNode curr = root;
    }
    public String longestWord(String[] words) {
        root = new TreeNode();
        
        for(String word:words){
            insert(word);
        }
        
        helper(words,new StringBuilder());
        return result;
        
    }
    
    public void helper(String[] words,StringBuilder path){
        
    }
}