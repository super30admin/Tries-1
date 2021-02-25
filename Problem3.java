//Time complexity-O(max length of string)
//Space complexity-O(length of unique prefix + number of suffix)
//Ran on leetcode:No
//Solution with comments- Failing some testcases
class Solution {
    class TrieNode{
        TrieNode[] children;
        String str;
        
        public TrieNode(){
            children= new TrieNode[26];
            str="";
        }
    }
    TrieNode root= new TrieNode();
    
     public void insert(List<String> dict){
         for(String word : dict){
             TrieNode curr=root;
             for(char c: word.toCharArray()){
                 if(curr.children[c-'a']==null){
                     curr.children[c-'a']= new TrieNode();
                 }
                 
                 curr=curr.children[c-'a'];
                 
             }
             curr.str=word;
         }
     }
    
    public void search(TrieNode curr, String word){//search the root word else return
        int count=0;
       for(char c : word.toCharArray() ){
           if(curr.children[c-'a']!=null){
               count++;
               curr=curr.children[c-'a'];
           }
       }
        if(count==curr.str.length())
            output+=curr.str+" ";
        else 
            output+=word+" ";
        return;
    }
    
    String output="";
    public String replaceWords(List<String> dictionary, String sentence) {
        insert(dictionary);
        
        
        String[] words = sentence.split(" ");
        for(String word: words){
            if(root.children[word.charAt(0)-'a']!=null)
                search(root,word);
            else
                output+=word +" ";
        }
        
        return output.substring(0,output.length()-1);
    }
}