class Trie {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();

    }

    // TC is O(L)
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

    // TC is O(L)
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

    // TC is O(length of prefix)
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
