import java.util.Arrays;
//Time Complexity : worst O(H), average O(1) where H is the number of nested lists
//Space Complexity :O(H) where H is the number of nested lists
//Did this code successfully run on Leet code :Yes
//Any problem you faced while coding this :
public class LongestWord {

    class TrieNode{
       boolean isEnd;
       TrieNode[] childrens;
       public TrieNode(){
           childrens = new TrieNode[26];
       }
   }
   
   TrieNode root;
   
     public void insert(String word) {
       char[] arr = word.toCharArray();
       TrieNode curr = root;
       for(char c:arr){
           int index = c-'a';
           if(curr.childrens[index]==null){
               curr.childrens[index] = new TrieNode();
                curr = curr.childrens[index];
           }else{
               curr = curr.childrens[index];
           }
       }
       curr.isEnd=true;
   }
   public boolean search(String word) {
       char[] arr = word.toCharArray();
       TrieNode curr = root;
       for(char c:arr){
           int index = c-'a';
           if(curr.childrens[index]==null){
               return false;
           }else{
               curr = curr.childrens[index];
           }
       }
       return curr.isEnd==true;
   }
   
   public String longestWord(String[] words) {
      int len=0;
      String result=""; 
      root = new TrieNode();
      Arrays.sort(words); 
     for(String word: words){
            StringBuilder sb = new StringBuilder();
            this.insert(word);
           for(int i=0;i<word.length();i++){
                   sb.append(word.charAt(i));
                  if(this.search(sb.toString())){
                      if(i+1>len){
                          len = i+1;
                          result = sb.toString();
                      }
                      else if(i+1==len){
                         String temp =  sb.toString();
                          result =result.compareTo(temp) <0 ?result:temp;
                      }
                  }else{
                      break;
                  }
                }
          
           }  
       return result;
   }
}
