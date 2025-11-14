/*
 * Trie (Prefix Tree)
 *
 * Approach:
 * - Standard Trie implementation with nodes for 26 lowercase English letters.
 * - Each node contains an array of child pointers and an isEnd flag to mark complete words.
 * - insert/search/startsWith operations traverse characters and create nodes as needed.
 *
 * Time Complexity:
 * - insert/search/startsWith: O(L) where L is the length of the word or prefix.
 *
 * Space Complexity:
 * - O(N) where N is the total number of characters inserted (each character may create a node).
 *   Alphabet size is treated as constant (26).
 *
 * LeetCode:
 * - https://leetcode.com/problems/implement-trie-prefix-tree/ (Problem 208)
 */

public class Trie {

    static class TrieNode {
        boolean isEnd;
        TrieNode[] nodes;

        public TrieNode() {
            nodes = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

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

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.nodes[c - 'a'] == null)  return false;
            current = current.nodes[c - 'a'];
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (current.nodes[c - 'a'] == null)  return false;
            current = current.nodes[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
    }

}
