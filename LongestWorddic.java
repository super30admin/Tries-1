// Time Complexity : O(n * m) where n is the number of words and m is the average length of the words
// Space Complexity : O(n * m) where n is the number of words and m is the average length of the words
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// This is a standard implementation of a Trie data structure.
// It consists of a root node and each node has an array of children representing the 26 lowercase English letters.
// The insert method adds words to the Trie, and the longestWord method finds the longest word in the Trie that can be built one character at a time by other words in the Trie
// The dfs method is used to traverse the Trie and build the longest word by checking if the current prefix is a valid word, backtracking to explore all possible paths. If the current prefix is a valid word, we continue to explore its children. We also keep track of the longest word found so far and update it if we find a longer one or a lexicographically smaller one of the same length.
//  If it is, we continue to explore its children. We also keep track of the longest word found so far and update it if we find a longer one or a lexicographically smaller one of the same length.
// The time complexity for the longestWord method is O(n * m) where n is the number of words and m is the average length of the words, and the space complexity is also O(n * m) due to the storage of nodes in the Trie.
class Solution {

    TrieNode root;
    String result;

    class TrieNode {

        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private void insert(String word) {

        TrieNode curr = root;

        for (char c : word.toCharArray()) {

            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }

            curr = curr.children[c - 'a'];
        }

        curr.isEnd = true;
    }

    public String longestWord(String[] words) {

        root = new TrieNode();
        result = "";

        for (String word : words) {
            insert(word);
        }

        dfs(root, new StringBuilder());

        return result;
    }

    private void dfs(TrieNode curr, StringBuilder path) {

        if (result.length() < path.length() ||
            (result.length() == path.length() &&
             path.toString().compareTo(result) < 0)) {

            result = path.toString();
        }

        for (int i = 0; i < 26; i++) {

            // Continue only if current prefix is a valid word
            if (curr.children[i] != null && curr.children[i].isEnd) {

                int len = path.length();

                path.append((char) ('a' + i));

                dfs(curr.children[i], path);

                // Backtrack
                path.setLength(len);
            }
        }
    }
}