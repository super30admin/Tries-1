// Time Complexity : O(n * m) where n is the number of words in the dictionary and m is the average length of the words
// Space Complexity : O(n * m) due to the storage of nodes in the Trie
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// This is a standard implementation of a Trie data structure.
// It consists of a root node and each node has an array of children representing the 26 lowercase English letters.
// The insert method adds words to the Trie, and the replaceWords method replaces words in a sentence with the shortest root from the dictionary that can form that word.
// The getShortestVersion method traverses the Trie to find the shortest root for a given word. If a root is found, it returns that root; otherwise, it returns the original word.
// The time complexity for the replace  Words method is O(n * m) where n is the number of words in the dictionary and m is the average length of the words, and the space complexity is also O(n * m) due to the storage of nodes in the Trie.
import java.util.List;

class Solution {

    TrieNode root;

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

    public String replaceWords(List<String> dictionary, String sentence) {

        root = new TrieNode();

        for (String word : dictionary) {
            insert(word);
        }

        StringBuilder result = new StringBuilder();

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {

            if (i > 0) {
                result.append(" ");
            }

            result.append(getShortestVersion(words[i]));
        }

        return result.toString();
    }

    private String getShortestVersion(String word) {

        TrieNode curr = root;

        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {

            if (curr.children[c - 'a'] == null || curr.isEnd) {
                break;
            }

            curr = curr.children[c - 'a'];
            sb.append(c);
        }

        if (curr.isEnd) {
            return sb.toString();
        }

        return word;
    }
}