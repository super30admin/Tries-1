/* Implement a trie with insert, search, and startsWith methods.*/
/* TC insert O(N) search O(N) and startsWith O(N)
* SC O(1)
*/
class Trie {

    class TrieNode {
        boolean lastNode;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
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
        for (int i = 0; i<word.length(); i++ ) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.lastNode = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i<word.length(); i++ ) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.lastNode;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i<prefix.length(); i++ ) {
            char c = prefix.charAt(i);
            if (curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true;
    }
}
