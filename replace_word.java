//Time Complexity: O(n*k) + O(m*k)
   // n - words
    //m - words in sentence
    //k - max length of word
  //  Space Complexity: O(n*k)

  class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode children[];
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    public void insert(TrieNode root, String word) {
        
        TrieNode current = root;
        for(int i =0; i<word.length();i++) {
            if(current.children[word.charAt(i)-'a'] == null) {
                current.children[word.charAt(i)-'a'] = new TrieNode();
            }
            current = current.children[word.charAt(i)-'a'];
        }
        current.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        
        StringBuilder result = new StringBuilder();
        for(int i=0; i<dictionary.size();i++) {
            insert(root,dictionary.get(i));
        }
        String []senArray = sentence.split(" ");
        for(int i =0; i<senArray.length;i++) {
            TrieNode current = root;
            if(i != 0) {
                result.append(" ");
            }
            String word = senArray[i];
            StringBuilder sb = new StringBuilder();
          for(int j =0; j< word.length();j++) {
              if(current.children[word.charAt(j)-'a'] == null || current.isEnd) {
                  break;
              }
              current = current.children[word.charAt(j)-'a'];
              sb.append(word.charAt(j));

          }
          if(current.isEnd) {
              result.append(sb);
          } else {
              result.append(word);
          }
 }
 return result.toString();
    }
}