//https://leetcode.com/problems/implement-trie-prefix-tree/
/*
Time: Insert, search, startsWith is O(N)
Space: Insert O(N), Search & startsWith is O(1)
*/
class TrieNode {
   // marker for end of word
   boolean isEndOfWord;
   // stores references
   TrieNode[] children;

   /* Constructor */

   public TrieNode() {
       children = new TrieNode[26];
   }
}

public class Trie{
   private TrieNode root;
   /** Initialize your data structure here. */

   public Trie() {
      // init empty trie
       root = new TrieNode();
   }

   /*
    * Inserts a word into the trie.
    * @param word to insert.
    */

   public void insert(String word) {
       TrieNode cursor = root;
       char c;

       for (int i = 0; i < word.length(); i++) { // iterate
           c = word.charAt(i);
           if (cursor.children[c - 'a'] == null) { // create if null
               cursor.children[c - 'a'] = new TrieNode();
           }
           cursor = cursor.children[c - 'a']; // update cursor
       }
       cursor.isEndOfWord = true; // mark end
   }

   /**
    * Returns if the word is in the trie
    * @param word to lookup.
    * @return true if exists, false otherwise.
    */

   public boolean search(String word) {
       TrieNode cursor = root;
       char c;
       for (int i = 0; i < word.length(); i++) { // iterate
           c = word.charAt(i);
           if (cursor.children[c - 'a'] == null) { // miss
               return false;
           }
           cursor = cursor.children[c - 'a']; // update cursor
       }
       return cursor.isEndOfWord;
}
   
   /**
    * Returns if there is any word in the trie that starts with the given prefix.
    */
   public boolean startsWith(String prefix) {
       TrieNode cursor = root;
       char c;
       for (int i = 0; i < prefix.length(); i++) { // iterate
           c = prefix.charAt(i);
           if (cursor.children[c - 'a'] == null) { // miss
               return false;
           }
           cursor = cursor.children[c - 'a']; // update cursor
       }
       return true;
   }
}

