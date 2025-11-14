/*
 * Replace Words
 *
 * Approach:
 * - Build a Trie of root words from the dictionary.
 * - For each word in the sentence, traverse the Trie character by character and stop
 *   when a node with isEnd == true is reached (the shortest root). If found, replace the
 *   word with this root; otherwise keep the original word.
 *
 * Time Complexity:
 * - Building the Trie: O(S) where S is the sum of lengths of all dictionary words.
 * - Replacing words in the sentence: O(W * L) where W is number of words in the sentence
 *   and L is average word length (each word is traversed at most its length while searching for a root).
 * - Overall: O(S + W * L).
 *
 * Space Complexity:
 * - O(S) for the Trie nodes.
 *
 * LeetCode:
 * - https://leetcode.com/problems/replace-words/ (Problem 648)
 */

import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {

    static class TrieNode {
        boolean isEnd;
        TrieNode[] nodes;

        public TrieNode() {
            nodes = new TrieNode[26];
        }
    }

    TrieNode root;

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.nodes[c - 'a'] == null) {
                current.nodes[c - 'a'] = new TrieNode();
            }
            current = current.nodes[c - 'a'];
        }
        current.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();

        for (String str : dictionary) {
            insert(str);
        }

        String[] strings = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            StringBuilder currentString = new StringBuilder();
            TrieNode current = root;
            for (char c : string.toCharArray()) {
                if (current.nodes[c - 'a'] == null || current.isEnd) {
                    break;
                }
                currentString.append(c);
                current = current.nodes[c - 'a'];
            }
            if (current.isEnd)
                stringBuilder.append(currentString);
            else
                stringBuilder.append(string);
            stringBuilder.append(" ");
        }

        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(new ReplaceWords().replaceWords(list, sentence));
    }
}
