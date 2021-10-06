public class longestwordinDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

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
        }
        curr.isEnd = true;
    }

    StringBuilder result;

    public String longestWord(String[] words) {
        root = new TrieNode();
        result = new StringBuilder();
        for (String word : words)
            insert(word);
        dfs(root, new StringBuilder());
        return result.toString();
    }

    private void dfs(TrieNode curr, StringBuilder path) {
        // base
        if (path.length() >= result.length()) {
            result = new StringBuilder(path);
        }
        // logic
        for (int i = 25; i >= 0; i--) {
            if (curr.children[i] != null && curr.children[i].isEnd) {
                char c = (char) (97 + i);
                path.append(c);
                dfs(curr.children[i], path);
                // backtrack
                path.setLength(path.length() - 1);
            }
        }

    }

}
