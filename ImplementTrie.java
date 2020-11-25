package Nov19;

class ImplementTrie {

/*    
     Time complexity: O(l) because we will iterate through each character of the word in the trie DS, i.e.length of the word.
    
     Space complexity: O(26*l) ~= O(l) because there will be a new Trienode for each character of the word and every trienode will have 26 elements in the children array.
   
     Did this code successfully run on Leetcode : Yes
    
     Any problem you faced while coding this : No
     
     Approach: 
     Trie implementation
      
*/
     class TrieNode {
        TrieNode[] children;
        boolean isLast;
        public TrieNode() {
            children = new TrieNode[26];
            isLast = false;
        }
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();  
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (curr.children[curChar - 'a'] == null) {
                curr.children[curChar - 'a'] = new TrieNode();
            }
            curr = curr.children[curChar - 'a'];
        }
        curr.isLast = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (curr.children[curChar - 'a'] == null) {
                return false;
            }
            curr = curr.children[curChar - 'a']; 
        }
        if (curr.isLast == true) {
            return true;
        } 
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curChar = prefix.charAt(i);
            if (curr.children[curChar - 'a'] == null) {
                return false;
            }
            curr = curr.children[curChar - 'a']; 
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