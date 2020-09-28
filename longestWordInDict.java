    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/longest-word-in-dictionary/
    Time Complexity for operators : o(n) .. n is word of length
    Extra Space Complexity for operators : o(n) n is number of characters
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. Trie
                    A) First create the trieNode class with 26 chracters of array and with isWord booelans flag.
                    B) For insert create Trienode for each of the word from the input.
                    C) At the end of the word make the word field to the total value that means word exists till that point.
                    D) for finding longest world in dict, do the dfs on the trie node.
                    E) The base case will be, if (root.word.length()>result.length())
                    F) for 26 character for loop, check childrens!=null and it has string != "" then traverse to next character.
                    F) At the end, return result string.
    */ 

class Solution {
    
    class TrieNode{
        TrieNode[] childrens;
        String word;
        
        public TrieNode(){
            childrens = new TrieNode[26];
            word = "";
        }
    }
    
    private TrieNode root;
    
    private void insert(String[] words){

        for(String word : words){
            
            TrieNode curr = root;
            
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                
                if(curr.childrens[ch - 'a'] == null){
                    curr.childrens[ch - 'a'] = new TrieNode();
                }
                
                curr = curr.childrens[ch - 'a'];
            }
            
            curr.word = word;
        }
    }
    
    private String result="";
    
    private void dfs(TrieNode root){
        
        if(root.word.length()>result.length())
            result = root.word;
        
        for(int i=0;i<26;i++){
            if(root.childrens[i]!=null && root.childrens[i].word!="")
                dfs(root.childrens[i]);
        }
    }
    
    public String longestWord(String[] words) {
        root = new TrieNode();
        
        insert(words);
        
        dfs(root);
        
        return result;
    }
}