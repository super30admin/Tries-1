//tc = O(N + M)
// sc = O(N)

import java.util.List;

public class ReplaceWords {
    
}
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        private TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word , TrieNode root){
        TrieNode curr = root;
        for(int i =0 ; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
              curr.children[c - 'a'] = new TrieNode();
             
            }
             curr = curr.children[c - 'a'];
        }
         curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String word : dictionary ){
            insert(word , root);
        }
        StringBuilder result = new StringBuilder();
        String[] splitArray = sentence.split(" ");
        for (int i =0 ; i < splitArray.length ; i++){
           String word = splitArray[i];
           
           StringBuilder replacement = new StringBuilder();
           if(i>0) result.append(" ");
           TrieNode curr = root;
           for(int k =0 ; k < word.length() ; k++){
               char c = word.charAt(k);
               if(curr.children[c -'a'] == null || curr.isEnd) {
                   break;
               }
               curr = curr.children[c -'a'];
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