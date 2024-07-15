// Time Complexity : O(nL + S), n-no of words, L- avg length of a word, S - ength of sentence
// Space Complexity : O(nL + S)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {

  class TrieNode {
    boolean isEnd;
    TrieNode[] children;
    TrieNode() {
      isEnd = false;
      children = new TrieNode[26];
    }
  }

  TrieNode root;
  void insert(String word) {
    TrieNode current = root;
    for(int i = 0; i<word.length(); i++) {
      char c = word.charAt(i);
      if(current.children[c - 'a'] == null) {
        current.children[c - 'a'] = new TrieNode();
      }
      current = current.children[c - 'a'];
    }
    current.isEnd = true;
  }

  public String replaceWords(List<String> dictionary, String sentence) {
    if(sentence.length() == 0 || sentence == null) return sentence;

    root = new TrieNode();
    for(String word: dictionary) {
      insert(word);
    }

    String[] strArray = sentence.split(" ");

    StringBuilder answer = new StringBuilder();
    for(String word: strArray) {
      TrieNode current = root;
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i<word.length(); i++) {
        char c = word.charAt(i);
        if(current.children[c - 'a'] == null || current.isEnd == true) {
          break;
        }
        sb.append(c);
        current = current.children[c-'a'];
      }
      if(current.isEnd == true) {
        answer.append(sb);
      }else {
        answer.append(word);
      }
      answer.append(" ");
    }
    return answer.toString().trim();
  }
}