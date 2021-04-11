// Time Complexity : O(n);
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class ImplementPrefixTree {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public ImplementPrefixTree() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;

        for(int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            if (curr.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            curr = curr.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}
