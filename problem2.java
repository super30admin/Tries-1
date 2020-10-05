// Time Complexity : O(n^2) 
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            word = "";
        }
    }

    private TrieNode root;
    private String result = "";

    private void dfs(TrieNode root) {

        if (root.word.length() > result.length()) {
            result = root.word;
        } else if (root.word.length() == result.length() && root.word.compareTo(result) < 0) {
            result = root.word;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].word != "") {
                dfs(root.children[i]);
            }
        }
    }

    private void insert(String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (int x = 0; x < word.length(); x++) {
                Character ch = word.charAt(x);
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.word = word;
        }
    }

    public String longestWord(String[] words) {

        root = new TrieNode();
        insert(words);
        dfs(root);
        return result;
    }

}