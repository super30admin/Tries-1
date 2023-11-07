// Time Complexity : O(n*m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] child;
        String word;
        public TrieNode(){
            this.isEnd = false;
            this.child = new TrieNode[26];
            this.word = "";
        }
    }
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
      this.root = new TrieNode();
      for(int i = 0; i < dictionary.size(); i++){
          String tmp = dictionary.get(i);
          TrieNode curr = root;
          for(int j = 0; j < tmp.length();j++){
              char c = tmp.charAt(j);
              
              if(curr.child[c-'a']==null)
                curr.child[c-'a'] = new TrieNode();
                curr = curr.child[c-'a'];
          }
          curr.isEnd=true;
      }
      String[] words = sentence.split(" ");
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < words.length; i++){
          String word = words[i];
          StringBuilder s3 = new StringBuilder();
          TrieNode curr = root;
          if(i > 0)
            sb.append(" ");
          for(int j = 0; j < word.length();j++){
              
              char c = word.charAt(j);
              
              if(curr.child[c-'a']==null || curr.isEnd ){
                  break;
              }
              s3.append(c);
              curr = curr.child[c-'a'];
          }
          if(!curr.isEnd)
            sb.append(word);
            else
            sb.append(s3);
      }
      return sb.toString();  
    }
}