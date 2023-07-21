public class ImplementTrie {
    class TrieNode {
        private boolean isEnd;
        private TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
            // isEnd = false;
        }
    }

    private TrieNode root;

    public ImplementTrie() {
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

    public boolean startsWith(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();

        // Insert words into the trie
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("car");

        // Search for words in the trie
        System.out.println(trie.search("apple")); // Output: true
        System.out.println(trie.search("banana")); // Output: true
        System.out.println(trie.search("cat")); // Output: false

        // Check if words start with a given prefix
        System.out.println(trie.startsWith("app")); // Output: true
        System.out.println(trie.startsWith("ban")); // Output: true
        System.out.println(trie.startsWith("dog")); // Output: false
    }
}