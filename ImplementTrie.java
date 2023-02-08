// Time Complexity : O(L) for all insert(), search(), startsWith() runs in O(L)
// Space Complexity : O(1) for all insert(), search(), startsWith() runs in O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// L is length of input string

public class ImplementTrie {

    static class Trie {

        class TrieNode {
            boolean isEnd;
            TrieNode[] children;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
            return true;
        }
    }
}
