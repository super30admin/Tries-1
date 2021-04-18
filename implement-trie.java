// Time: O(length of word)
// Space: O(total number of characters * 26)

class TrieNode{
  TrieNode[] children;
  boolean isWord;
  TrieNode(){
    children = new TrieNode[26];
    isWord = false;
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
      TrieNode curr = root;
        for(char ch:word.toCharArray()){
          // char ch = word.charAt(i);
          
          if(curr.children[ch-'a'] == null){
            curr.children[ch-'a'] = new TrieNode();
          }
          curr = curr.children[ch-'a'];
        }
      curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
     
       for(char ch:word.toCharArray()){
          //char ch = word.charAt(i);
          if(curr.children[ch-'a'] == null) return false;
          curr = curr.children[ch-'a'];
        }
      //if(curr == null) return false;
      return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      TrieNode curr = root;
     //if(curr == null) return false;
      for(char ch:prefix.toCharArray()){
        if((curr.children[ch-'a'] == null)){
          return false;
        }
        //if(curr == null) return false;
        curr = curr.children[ch-'a'];
      }
     // if(curr == null) return false;
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
