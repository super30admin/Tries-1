    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/replace-words/
    Time Complexity for operators : o(n) .. n is word of length
    Extra Space Complexity for operators : o(n) n is number of characters
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. Trie
                    A) First create the trieNode class with 26 chracters of array and with isWord booelans flag.
                    B) For inserT create Trienode for each of the character from  word dictionary the input.
                    C) At the end of the word make the word field to the total value that means word exists till that point.
                    D) for each sentence, check whether it startswith the word from dictionry if it is then replace it
                       else let it be as it is.
                    F) Return, final changed sentence at the end.
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
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        insert(dictionary);
        String str[] = sentence.split(" ");
        for(String strs:str){
            startswith(root,strs);
        }
        return sb.toString();
    }
    
    StringBuilder sb = new StringBuilder();

    
    // this function will return min common word in the entire string
    private void startswith(TrieNode root, String word){
            TrieNode curr = root;
        
            if (sb.length() > 0)
                sb.append(" ");
        
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                
                if(curr.childrens[ch-'a']==null || curr.word != ""){
                      break;
                }
                curr = curr.childrens[ch-'a'];
            }
        
            sb.append(curr.word != "" ? curr.word : word);

        return;
    }
        
    //it will create a Trie
    private void insert(List<String> dictionary){
        
        for(String word : dictionary){
            
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                
                if(curr.childrens[ch-'a'] == null){
                    curr.childrens[ch-'a'] = new TrieNode();
                }
                
                curr = curr.childrens[ch-'a'];
            }
            curr.word = word;
        }
    }
}