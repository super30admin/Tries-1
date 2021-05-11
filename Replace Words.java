// Time Complexity : O(n*m) 
// Space Complexity : O(k) 
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach: 
class Solution {

  class TrieNode {
    boolean isLast;
    TrieNode[] children;

    public TrieNode() {
      isLast = false;
      children = new TrieNode[26];
    }
  }

  TrieNode root;

  private void insert(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (cur.children[c - 'a'] == null)
        cur.children[c - 'a'] = new TrieNode();
      cur = cur.children[c - 'a'];
    }
    cur.isLast = true;
  }

  public String replaceWords(List<String> dictionary, String sentence) {
    if (dictionary == null || dictionary.size() == 0)
      return sentence;

    root = new TrieNode();
    for (String word : dictionary)
      insert(word);

    StringBuilder finalStr = new StringBuilder();
    StringBuilder tempStr = new StringBuilder();

    String[] sentence_list = sentence.split(" ");

    for (int i = 0; i < sentence_list.length; i++) {
      if (i > 0)
        finalStr.append(" ");

      tempStr = new StringBuilder();
      TrieNode cur = root;
      for (int j = 0; j < sentence_list[i].length(); j++) {
        char c = sentence_list[i].charAt(j);
        if (cur.children[c - 'a'] == null || cur.isLast)
          break;
        tempStr.append(c);
        cur = cur.children[c - 'a'];
      }

      if (cur.isLast)
        finalStr.append(tempStr);
      else
        finalStr.append(sentence_list[i]);

    }
    return finalStr.toString();

  }
}