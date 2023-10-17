
public class ImplementTriePrefixTree {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char single = word.charAt(i);
            if (current.children[single - 'a'] == null) {
                current.children[single - 'a'] = new TrieNode();
            }
            current = current.children[single - 'a'];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char single = word.charAt(i);
            if (current.children[single - 'a'] == null) {
                return false;
            }
            current = current.children[single - 'a'];
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char single = prefix.charAt(i);
            if (current.children[single - 'a'] == null) {
                return false;
            }
            current = current.children[single - 'a'];
        }
        return true;
    }
}
