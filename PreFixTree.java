// Time Complexity O(L)
// Space Complexity O(n x L)
// Runs on LeetCode YES

class Trie {
    TrieNode root;

    class TrieNode {
        Character val;
        boolean isEnd;
        TrieNode[] children;

        TrieNode(char ch) {
            this.val = ch;
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode(ch);
            }
            current = current.children[ch - 'a'];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (current.children[ch - 'a'] == null) {
                return false;
            }
            current = current.children[ch - 'a'];
        }

        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (current.children[ch - 'a'] == null) {
                return false;
            }
            current = current.children[ch - 'a'];
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