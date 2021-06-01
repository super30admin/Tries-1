// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(nL + N) where nL is the complexity for building the trie n words of each L length 
// where N is the number of characters in the sentence.
//Space Complexity: O(26 power n) since we are creating a new array for every case and considering we are having 26 alphabets 
taking any extra space

class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    
    TrieNode root;       
    public void insert(String word) 
    {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) 
    {
      root = new TrieNode();  
      //Insert all the words into the trie
      for(String word : dictionary){
         insert(word);
      }  
        
      String[] wordArray = sentence.split("\\s+");
      StringBuilder result = new StringBuilder();
      StringBuilder replacedWord;
      for(int k = 0; k < wordArray.length; k++){
          String word = wordArray[k];
          replacedWord = new StringBuilder();
          
          //Insert spaces
          if(k > 0){
            result.append(" ");    
          }
          
          var curr = root;
          for(int i = 0; i < word.length(); i++){
              char c = word.charAt(i);
              if(curr.children[c - 'a'] == null || curr.isEnd) break;
              curr = curr.children[c - 'a'];
              replacedWord.append(c);
          }
          
          if(curr.isEnd){
              result.append(replacedWord.toString());
          }
          else{
              result.append(word);
          }
      }
        return result.toString();
     }      
}