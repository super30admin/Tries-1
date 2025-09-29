public class ImplementTrie {

    private class TrieNode {
        private boolean end;
        private final TrieNode[] children;

        private TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private final TrieNode root;

    public ImplementTrie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.end = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) return false;
            current = current.children[index];
        }

        return current.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) return false;
            current = current.children[index];
        }

        return true;
    }
}
