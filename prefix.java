// Time Complexity : O(n) for insert, search, and startsWith where n is the length of the word or prefix
// Space Complexity : O(26 * n) in the worst case for storing Trie nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use a Trie data structure where each node stores references to the next possible characters and a flag to mark the end of a valid word.
// Insert traverses character by character and creates missing nodes, while search and startsWith traverse similarly to verify whether the path exists in the Trie.
// Search returns true only if the final node marks the end of a word, whereas startsWith only checks whether the prefix path is present.


public class prefix-trie {
    class TrieNode {
        TrieNode [] children;
        boolean isEnd;
        
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch-'a'] == null) return false;
            curr = curr.children[ch-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (curr.children[ch-'a'] == null) return false;
            curr = curr.children[ch-'a'];
        }
        return true;
    }
}
