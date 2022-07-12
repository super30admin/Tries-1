// TimeComplexity : O(n) where 'n' is the number of words in the sentence
// SpaceComplexity: O(m*l) where 'm' is the number of words in the dictionary
// Did your code successfully executed on leetcode : Yes
import java.util.*;
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
     TrieNode root;
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
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
      for(String str: dictionary){
          insert(str);
      }
        StringBuilder result = new StringBuilder();
        String[] strArr = sentence.split(" ");
        
        for(int i=0; i<strArr.length;i++){
           String word = strArr[i];
            if(i!=0){
                result.append(" ");
            }
           StringBuilder replacement  = new StringBuilder();
            TrieNode curr = root;
            for(int k=0; k< word.length(); k++){
                char c = word.charAt(k);
                if(curr.children[c-'a'] == null || curr.isEnd){
                    break;
                }
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd){
                result.append(replacement);
            }
            else{
                result.append(word);
            }
        }
        return result.toString();
    }
}