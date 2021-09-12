/*
Time: O(nk)
Space: Trie O(nk) + Queue O(nk)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();

        for (String word : words)
            trie.insert(word);

        return trie.findLongestWord();
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null)
                    node.children[idx] = new TrieNode();

                node = node.children[idx];
            }

            node.isWord = true;
            node.word = word; // remember to store the word
        }

        // BFS
        public String findLongestWord() {
            String result = "";
            Queue<TrieNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TrieNode node = q.poll();
                    for (int j = 25; j >= 0; j--) // right to left -> because we need lexicographyically smaller
                    {
                        if (node.children[j] != null && node.children[j].isWord && node.children[j].word != null) {
                            result = node.children[j].word;
                            q.offer(node.children[j]);
                        }
                    }
                }
            } // look at what came out of the queue at the end, that will be your ans
            return result;
        }
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}