  /**
    Time Complexity : O(N * L)
    Explanation:
    - Inserting all words into Trie takes O(N * L)
    - DFS traversal explores valid nodes (only words whose prefixes exist)
    Overall linear in total characters.

    Space Complexity : O(N * L)
    Explanation:
    Trie stores all characters of all words.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about how to ensure that only valid words
    (where all prefixes exist) are considered.
    Fixed it by:
        - Marking root.isEnd = true
        - Traversing only nodes where isEnd == true
    Also needed to carefully backtrack the StringBuilder
    to maintain correct word formation.
    */
    class Solution {


        class TrieNode {
            boolean isEnd;
            TrieNode[] children;
    
            public TrieNode() {
                this.children = new TrieNode[26];
            }
        }
    
        TrieNode root = new TrieNode();
        String maxString;
    
        public String longestWord(String[] words) {
    
            this.maxString = "";
    
            // Important: root acts like empty prefix
            this.root.isEnd = true;
    
            // Build Trie
            for (String word : words) {
                insert(word);
            }
    
            // DFS to find longest valid word
            helper(root, new StringBuilder());
    
            return maxString;
        }
    
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
    
        private void helper(TrieNode currNode, StringBuilder currString) {
    
            // Only proceed if current prefix is a valid word
            if (!currNode.isEnd) return;
    
            // Update result (lexicographically smaller handled by traversal order)
            if (currString.length() > maxString.length()) {
                maxString = currString.toString();
            }
    
            // Explore children (a → z ensures lexicographic order)
            for (int i = 0; i < 26; i++) {
    
                if (currNode.children[i] != null) {
    
                    int len = currString.length();
    
                    currString.append((char) (i + 'a'));
    
                    helper(currNode.children[i], currString);
    
                    // Backtrack
                    currString.setLength(len);
                }
            }
        }
    }