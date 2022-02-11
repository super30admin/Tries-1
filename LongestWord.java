public class LongestWord {
    // Time Complexity: O(∑wi ​),where w_i is the length of words[i].
    // This is the complexity to build the trie and to search it.
    // Space Complexity: O(∑wi), the space used by our trie.
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        char ch;

        public TrieNode() {
            children = new TrieNode[26];

        }
    }

    TrieNode root;

    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
            curr.ch = c;
        }
        curr.isEnd = true;
    }

    String result;

    public String longestWord(String[] words) {
        root = new TrieNode();
        result = "";
        for (String word : words) {
            insert(word);
        }
        backtrack(root, new StringBuilder());
        return result;
    }

    private void backtrack(TrieNode curr, StringBuilder path) {
        if (path.length() >= result.length()) {
            result = path.toString();
        }
        for (int i = 25; i >= 0; i--) {
            if (curr.children[i] != null && curr.children[i].isEnd) {
                path.append(curr.children[i].ch);
                backtrack(curr.children[i], path);
                path.setLength(path.length() - 1);
            }
        }
    }
}
