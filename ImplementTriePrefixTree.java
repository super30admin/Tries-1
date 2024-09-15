// Time Complexity : O(n) length of the word for insert/search/startWith. 
// Space Complexity :   O(n) for insert. O(1) for search/startWith.  
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code uses a hashmap of Trie, if the element doesn't exist create a new Trie in that key of map, then move pointer to the new Trie, and repeat operation until no more chars 
//need to be added to tree.
//Success
//Details 
//Runtime: 42 ms, faster than 22.08% of Java online submissions for Implement Trie (Prefix Tree).
//Memory Usage: 51.6 MB, less than 94.23% of Java online submissions for Implement Trie (Prefix Tree)..
class Trie {
   Map<Character, Trie> children = null;
   boolean isWord = false;
  /** Initialize your data structure here. */
  public Trie() {
    this.children = new HashMap<>();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
     if (word != null && !" ".equals(word)) {
      Trie current = this;
      for (int i = 0; i < word.length(); i++) {
        if (current.children.get(word.charAt(i)) == null) {
          current.children.put(word.charAt(i), new Trie());
        }
        current = current.children.get(word.charAt(i));
      }
      current.isWord = true;
    }
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    if (word == null || " ".equals(word)) return false;
    Trie current = this;
    for (int i = 0; i < word.length(); i++) {
      if (current.children.get(word.charAt(i)) == null) return false;
      current = current.children.get(word.charAt(i));
    }
    return current.isWord;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    if (prefix == null || " ".equals(prefix)) return false;
    Trie current = this;
    for (int i = 0; i < prefix.length(); i++) {
      if (current.children.get(prefix.charAt(i)) == null) return false;
      current = current.children.get(prefix.charAt(i));
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