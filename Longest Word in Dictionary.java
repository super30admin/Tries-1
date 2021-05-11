// Time Complexity : O(n*m) 
// Space Complexity : O(n*m) 
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach:

class TrieNode {
  String word;
  TrieNode[] children;

  public TrieNode() {
    children = new TrieNode[26];
  }
}

class Solution {
  TrieNode root;

  private void insert(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new TrieNode();
      }
      cur = cur.children[c - 'a'];
    }
    cur.word = word;
  }

  public String longestWord(String[] words) {
    if (words == null || words.length == 0)
      return "";

    root = new TrieNode();
    for (String word : words) {
      insert(word);
    }

    Queue<TrieNode> q = new LinkedList<>();
    q.add(root);
    TrieNode cur = root;

    while (!q.isEmpty()) {
      cur = q.poll();
      for (int i = 25; i >= 0; i--) {
        if (cur.children[i] != null && cur.children[i].word != null) {
          q.add(cur.children[i]);
        }
      }
    }
    if (cur.word == null)
      return "";
    return cur.word;
  }
}