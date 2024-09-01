// Problem 648. Replace Words
// Time Complexity : O((N+K)*L)
// Space Complexity : O(N*L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class ReplaceWords {
    // Definition
    private class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        // Constructor for TrieNode
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
    private void insert(TrieNode root, String word) {
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
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        // Insert all dictionary words into the Trie
        for (String word : dictionary) {
            insert(root, word);
        }
        String[] strArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < strArr.length; k++) {
            String currWord = strArr[k];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            // Find the shortest prefix in the Trie for currWord
            for (int i = 0; i < currWord.length(); i++) {
                char c = currWord.charAt(i);
                if (curr.children[c - 'a'] == null || curr.isEnd) {
                    break;
                }
                curr = curr.children[c - 'a'];
                replacement.append(c);
            }
            if (curr.isEnd) {
                result.append(replacement.toString());
            } else {
                result.append(currWord);
            }
            if (k < strArr.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}

