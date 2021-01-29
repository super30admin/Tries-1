// https://leetcode.com/problems/implement-trie-prefix-tree/

// Space complexity : O(Number of words * Average length of word)
class Trie {
    class TrieNode {
        boolean isEnd;
        TrieNode children[];

        public TrieNode() {
            children = new TrieNode[26];
        }

    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    // Time complexity : O(word length)
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    // Time complexity : O(word length)
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }

    // Time complexity : O(word prefix)
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}