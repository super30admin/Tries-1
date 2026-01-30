public class PrefixTree {
    TrieNode root;

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    public PrefixTree() {
        this.root = new TrieNode();
    }
    /*
     * Insert a root word into the trie.
     * Time: O(L) where L = word length
     */

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }
    /*
     * Search a root word into the trie.
     * Time: O(L) where L = word length because we search through at most k characters in the trie.
     */

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return curr.isEnd;
    }

    /*
     * Search a root word that starts with given prefix
     * Time: O(L) where L = word length because we search through at most k characters in the trie.
     */

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return true;
    }

    // Test
    public static void main(String[] args) {
        PrefixTree trie = new PrefixTree();

        // Insert words
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");
        trie.insert("bath");
        trie.insert("bad");

        // Basic searches
        System.out.println("search(\"app\")    = " + trie.search("app"));    // true
        System.out.println("search(\"apple\")  = " + trie.search("apple"));  // true
        System.out.println("search(\"ap\")     = " + trie.search("ap"));     // false (prefix only, not a full word)

        // Prefix checks
        System.out.println("startsWith(\"ba\")   = " + trie.startsWith("ba"));   // true
        System.out.println("startsWith(\"bat\")  = " + trie.startsWith("bat"));  // true
        System.out.println("startsWith(\"cat\")  = " + trie.startsWith("cat"));  // false

        // Edge-ish cases
        trie.insert(""); // inserts empty string as a word
        System.out.println("search(\"\")        = " + trie.search(""));          // true
        System.out.println("startsWith(\"\")    = " + trie.startsWith(""));      // true (empty prefix always matches)
    }
}
