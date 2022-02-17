//  Time Complexity: Insert - O(n), Search - O(n), StartsWith - O(n)
//  Space Complexity: Insert - O(n), Search - O(1), StartsWith - O(1)

public class ImplementTrie_PrefixTree {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public ImplementTrie_PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }

            cur = cur.children[c - 'a'];
        }

        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }

            cur = cur.children[c - 'a'];
        }

        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;

        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }

            cur = cur.children[c - 'a'];
        }

        return true;
    }
}
