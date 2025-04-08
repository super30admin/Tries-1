// Time Complexity : O(n x K) where n = no. of words, K = length of longest word
// Space Complexity : O(n × K) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    // Trie node definition
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;
    StringBuilder maxStr;

    // Insert a word into the Trie
    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    // Return the longest word with all prefixes present
    public String longestWord(String[] words) {
        root = new TrieNode();
        maxStr = new StringBuilder();

        for (String word : words) // O(n * k)
            insert(word);

        backtrack(root, new StringBuilder());
        return maxStr.toString();
    }

    // DFS backtracking to find the longest valid word
    private void backtrack(TrieNode curr, StringBuilder currStr) {
        if (currStr.length() > maxStr.length()) {
            maxStr = new StringBuilder(currStr);
        }

        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null && curr.children[i].isEnd) {
                int len = currStr.length();
                currStr.append((char) (i + 'a'));     // action
                backtrack(curr.children[i], currStr); // recurse
                currStr.setLength(len);               // backtrack
            }
        }
    }
}
