// T : O(nk)
// S : O(nk)

class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

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

    StringBuilder maxStr;

    public String longestWord(String[] words) {
        root = new TrieNode();
        maxStr = new StringBuilder();
        for (String word : words) {
            insert(word);
        }
        backtrack(root, new StringBuilder());
        return maxStr.toString();
    }

    private void backtrack(TrieNode curr, StringBuilder currStr) {
        // base
        if (currStr.length() > maxStr.length()) {
            maxStr = new StringBuilder(currStr);
        }

        // logic
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null && curr.children[i].isEnd) {
                // action
                int le = currStr.length();
                currStr.append((char) (i + 'a'));
                // recurse
                backtrack(curr.children[i], currStr);
                // backtrack
                currStr.setLength(le);
            }
        }

    }
}
