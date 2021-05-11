// Time Complexity : O(N) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach: 

class TrieNode {
  boolean isLast;
  TrieNode[] children;

  public TrieNode() {
    children = new TrieNode[26];
  }
}

class Trie {
  TrieNode root;

  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new TrieNode();
      }
      cur = cur.children[c - 'a'];
    }
    cur.isLast = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (cur.children[c - 'a'] == null) {
        return false;
      }
      cur = cur.children[c - 'a'];
    }
    return cur.isLast;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    TrieNode cur = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (cur.children[c - 'a'] == null) {
        return false;
      }
      cur = cur.children[c - 'a'];
    }
    return true;
  }
}