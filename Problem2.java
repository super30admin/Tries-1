// https://leetcode.com/problems/longest-word-in-dictionary/
// Time comlpexity : O(Number of words * Average word length)
// Space comlpexity: O(Length of average word length)

class Solution {
    class TrieNode {
        boolean isEnd;
        boolean isRoot;
        TrieNode children[];

        public TrieNode() {
            children = new TrieNode[26];
        }

        public TrieNode(boolean isRoot) {
            children = new TrieNode[26];
            this.isRoot = isRoot;
        }
    }

    class Trie {
        TrieNode root;
        String longest;

        public Trie() {
            root = new TrieNode(true);
            longest = new String();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

        public void longestWord(TrieNode curr, StringBuilder res) {
            if (curr.isEnd == false && curr.isRoot == false)
                return;

            if (res.length() > longest.length())
                longest = res.toString();

            for (int i = 0; i < 26; i++) {
                if (curr.children[i] == null)
                    continue;

                res.append((char) (i + 'a'));
                longestWord(curr.children[i], res);
                res.setLength(res.length() - 1);
            }
        }

    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        trie.longestWord(trie.root, new StringBuilder());
        return trie.longest;

    }
}
