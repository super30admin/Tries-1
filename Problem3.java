//Time complexity-O(max length of string)
//Space complexity-O(length of unique prefix + number of suffix)
//Ran on leetcode:Yes
//Solution with comments- 
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
    
     public void insert(List<String> dict){//insert to trie and this willl update the smallest prefix as well.
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
    
    public void search(TrieNode curr, String word){
       for(char c : word.toCharArray() ){
           if(curr.children[c-'a']==null ||!curr.str.equals("")){//If we reached to the end of trie path  or prefix length is exhausted
               break;
           }
           else if(curr.children[c-'a']!=null){
               curr=curr.children[c-'a'];
           }
       }
        if(curr.str.equals(""))//if no valid prefix found for sentecne word
            output+=word+" ";    
        else
            output+=curr.str+" ";//if prefix is found
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