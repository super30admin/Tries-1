/**
 * 
 * LeetCode Problem #: 208
 * LeetCode Problem Link:
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * Trie data structure implementation in Java.
 * Supports insertion of words, searching for complete words,
 * Time Complexity: O(m) for insert, search, and startsWith operations,
 * where m is the length of the word or prefix.
 * Space Complexity: O(m) for each word inserted.
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Trie.TrieNode child = curr.children[c - 'a'];
            if (child == null) {
                TrieNode n = new TrieNode();
                curr.children[c - 'a'] = n;
                curr = n;
            } else {
                curr = child;
            }
            if (i == word.length() - 1) {
                curr.isEnd = true;
            }
        }
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return false;
            } else {
                curr = curr.children[c - 'a'];
            }
        }
        if (curr.isEnd)
            return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.children[c - 'a'] == null || i != prefix.length() - 1 || curr.children[c - 'a'].isEnd) {
                return false;
            } else {
                curr = curr.children[c - 'a'];
            }
        }
        return true;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // return True
        System.out.println(trie.search("app")); // return False
        System.out.println(trie.search("appleo")); // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app")); // return True
        System.out.println(trie.startsWith("a")); // return True

    }
}