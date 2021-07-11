//Time complexity - O(nk+l) - l is the total number of character in word
//Space complexity - O(nk+l)


class Solution {
    class TrieNode{
      boolean isEnd;
      TrieNode[] children;
      public TrieNode() {
        this.children = new TrieNode[26];
      }
    }
  //insert given list of words in trie
   TrieNode root;
    private void insert(String word) {
      TrieNode curr = root;
      for(int i = 0;i< word.length();i++) {
        char c = word.charAt(i);
        if(curr.children[c-'a'] == null) {
          curr.children[c-'a'] = new TrieNode();
        }
        curr = curr.children[c-'a'];
      }
      curr.isEnd = true;
    }
   StringBuilder result = new StringBuilder();
  
    public String replaceWords(List<String> dictionary, String sentence) {
      root = new TrieNode();
      //inser all the given words in trie
      for(String word : dictionary) {
        insert(word);
      }
      
      //split the sentence into array of words
      String [] splitArr = sentence.split("\\s+");
      for(int k = 0; k< splitArr.length;k++) {
        if(k>0) result.append(" ");
        String word = splitArr[k];
        StringBuilder replacement = new StringBuilder();
        TrieNode curr = root;
        //check each letter in the word exist in trie
        for(int i = 0;i< word.length();i++) {
        char c = word.charAt(i);
        if(curr.children[c-'a'] == null || curr.isEnd) {
          break;
        }
          //if found append it in replacement
          curr = curr.children[c-'a'];
          replacement.append(c);
        
       }
      if(curr.isEnd) { // found smaller prefix
        result.append(replacement);
      } else { // the corresponding smaller prefix is not found
        result.append(word);
      }
    }
      return result.toString();
      
    }
}