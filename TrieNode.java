// Time Complexity = O(m), m is word length
// Did this code successfully run on Leetcode : yes

class TrieNode {
   boolean isEndOfWord; // shows end of string
   TrieNode[] children; // references to child nodes
   public TrieNode() {
       children = new TrieNode[26];
   }
}

public class Trie{
   private TrieNode root;
   public Trie() {
       root = new TrieNode();  // initialize empty tree
   }
   // method inserts word into Trie, takes word as parameter
   public void insert(String word) {
       TrieNode position = root;
       char c;
       for (int i = 0; i < word.length(); i++) { 
           c = word.charAt(i);
           if (position.children[c - 'a'] == null) {
               position.children[c - 'a'] = new TrieNode();
           }
           position = position.children[c - 'a']; 
       }
       position.isEndOfWord = true; 
   }
   
   // method searchs word(parameter) in Trie, returns true if it is there, else false
   public boolean search(String word) {
       TrieNode position = root;
       char c;
       for (int i = 0; i < word.length(); i++) { 
           c = word.charAt(i);
           if (position.children[c - 'a'] == null) { 
               return false;
           }
           position = position.children[c - 'a']; 
       }
       return position.isEndOfWord;
   }
   
     // method checks if any string in the tree begins with the given sequence.
   public boolean startsWith(String prefix) {
       TrieNode position = root;
       char c;
       for (int i = 0; i < prefix.length(); i++) { // iterate
           c = prefix.charAt(i);
           if (position.children[c - 'a'] == null) { // miss
               return false;
           }
           position = position.children[c - 'a']; // update position
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