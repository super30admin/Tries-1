// Time Complexity : O(M × L + N × L)
// Space Complexity : O(M × L + N × L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

class Solution {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    // Inserts a word into the Trie
    public void insert(String word) {
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

    // Replaces words in the sentence with the shortest root word in the dictionary
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();

        // Build the Trie from dictionary
        for (String str : dictionary) {
            insert(str); // O(M * L)
        }

        StringBuilder result = new StringBuilder();
        String[] strArr = sentence.split(" "); // SC = O(N * L)

        for (int k = 0; k < strArr.length; k++) {
            String word = strArr[k];

            if (k != 0) result.append(" "); // Add space before all words except the first

            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null || curr.isEnd) {
                    break;
                }
                replacement.append(c);
                curr = curr.children[c - 'a'];
            }

            if (curr.isEnd) {
                result.append(replacement); // Use root word
            } else {
                result.append(word); // Use original word
            }
        }

        return result.toString();
    }
}
