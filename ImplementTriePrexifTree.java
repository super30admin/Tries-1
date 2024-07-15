// Time Complexity : O(n)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Trie {
  class TrieNode {
    boolean isEnd;
    TrieNode[] children;
    TrieNode() {
      isEnd = false;
      children = new TrieNode[26];
    }
  }

  TrieNode root;
  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
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

  public boolean search(String word) {
    TrieNode current = root;
    for(int i = 0; i<word.length(); i++) {
      char c = word.charAt(i);
      if(current.children[c - 'a'] == null) {
        return false;
      }
      current = current.children[c - 'a'];
    }
    return current.isEnd;
  }

  public boolean startsWith(String prefix) {
    TrieNode current = root;
    for(int i = 0; i<prefix.length(); i++) {
      char c = prefix.charAt(i);
      if(current.children[c - 'a'] == null) {
        return false;
      }
      current = current.children[c - 'a'];
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */