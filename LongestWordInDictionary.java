/*
 * Longest Word in Dictionary
 *
 * Approach:
 * - Build a Trie from the input words. For each word we traverse/create nodes for its characters.
 * - Track the longest word built from existing prefixes as words are inserted (this variant
 *   keeps track while inserting). The implementation chooses the lexicographically smallest
 *   word when lengths tie.
 *
 * Time Complexity:
 * - Building the Trie: O(S) where S is the sum of lengths of all words.
 * - Overall: O(S).
 *
 * Space Complexity:
 * - O(S) for the Trie nodes (alphabet size is constant = 26).
 *
 * LeetCode:
 * - https://leetcode.com/problems/longest-word-in-dictionary/ (Problem 720)
 */

public class LongestWordInDictionary {

    class TrieNode {
        boolean isEnd;
        TrieNode[] nodes;

        public TrieNode() {
            nodes = new TrieNode[26];
        }
    }

    private TrieNode root;

    public String longestWord(String[] words) {
        root = new TrieNode();
        String longestWord = "";
        int longestWordSize = 0;
        for (String word : words) {
            int currentLongestWordSize = 0;
            StringBuilder currentLongestWord = new StringBuilder();
            TrieNode currentNode = root;
            for (char ch : word.toCharArray()) {
                currentLongestWord.append(ch);
                if (currentNode.nodes[ch - 'a'] != null) {
                    currentLongestWordSize++;
                } else {
                    currentNode.nodes[ch - 'a'] = new TrieNode();
                }
                currentNode = currentNode.nodes[ch - 'a'];
            }
            if (currentLongestWordSize > longestWordSize) {
                longestWord = currentLongestWord.toString();
                longestWordSize = currentLongestWordSize;
            } else if (currentLongestWordSize == longestWordSize) {
                if (currentLongestWord.toString().compareTo(longestWord) < 0) {
                    longestWord = currentLongestWord.toString();
                }
            }
        }

        return longestWord;
    }

    public static void main(String[] args) {
        System.out.println(new LongestWordInDictionary().longestWord(new String[] {"a","banana","app","appl","ap","apply","apple"}));
    }
}
