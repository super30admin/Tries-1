//Time complexity-O(max length of string)
//Space complexity-O(length of unique prefix + number of suffix)
//Ran on leetcode:Yes
//Solution with comments-
class Solution {
    class TrieNode{
        TrieNode[] children ;
        String str;
        
        public TrieNode(){
            children= new TrieNode[26];
            str="";
        }
    }
   
   TrieNode root= new TrieNode();
   int max=0;
   String output="";
   
   public void dfs(TrieNode curr){//check if valid word exist in trie for the whole 26 chars.        
       if(curr.str.length()>output.length())
           output=curr.str;
       
        for(int i=0;i<26;i++){
         if(curr.children[i]!=null && curr.children[i].str!=""){
             if(curr.children[i].str.length()==max){
               output= curr.children[i].str;
                 return;
             }
             dfs(curr.children[i]);
               
         }
     }
   }
   
   public String longestWord(String[] words) {
      
       for(String word: words){//Insert all the elements to trie
            TrieNode curr= root;
           for(char c : word.toCharArray()){
               if(curr.children[c-'a']==null){
                   curr.children[c-'a']=new TrieNode();
               }
               curr=curr.children[c-'a'];
           }
           curr.str=word;
       }
       dfs(root);
       return output;
   
   }
}