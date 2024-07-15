// Time Complexity : O(L*nlog n), n - no of words, L - avg length of each word
// Space Complexity : O(nL)
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
      if(current.children[c-'a'] == null) {
        current.children[c-'a'] = new TrieNode();
      }
      current = current.children[c-'a'];
    }
    current.isEnd = true;
  }

  public String longestWord(String[] words) {
    if(words == null || words.length == 0) return "";

    root = new TrieNode();
    // Add all the words to a trie
    for(String word: words) {
      insert(word);
    }

    Arrays.sort(words, (a,b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());

    String longestWord = "";
    for(String word: words) {
      // Checking if each letter in the word is ser to true.
      if(canBeBuilt(word)) {
        if(word.length() > longestWord.length()) {
          longestWord = word;
        }
      }
    }
    return longestWord;
  }

  boolean canBeBuilt(String word) {
    TrieNode current = root;
    for(int i = 0; i<word.length(); i++) {
      char c = word.charAt(i);
      current = current.children[c-'a'];
      if(current == null || !current.isEnd) {
        return false;
      }
    }
    return true;
  }
}