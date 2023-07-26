// Time Complexity : O(n*L + m*L)
// Space Complexity : O(n*L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.List;

class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean end;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public void insert(String word) { // O(1)
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.end = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for (String word : dictionary) {// n*l
            insert(word);
        }
        String[] strArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < strArr.length; k++) {// m*l
            String word = strArr[k];
            if (k > 0)
                result.append(" ");
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.end || curr.children[c - 'a'] == null) {
                    break;
                }
                curr = curr.children[c - 'a'];
                replacement.append(c);
            }
            if (!curr.end) {
                result.append(word);
            } else {
                result.append(replacement.toString());
            }
        }
        return result.toString();
    }
}