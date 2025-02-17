/**
 * Time Complexity: 
 * - Insert : O(l)
 * - Search : O(l)
 * - StartsWith : O(l)
 * Space Complexity: 
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 
 */

public class Trie {
    
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (curr.children[currChar - 'a'] == null) {
                curr.children[currChar - 'a'] = new TrieNode();
            }
            curr = curr.children[currChar - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (curr.children[currChar - 'a'] == null) {
                return false;
            }
            curr = curr.children[currChar - 'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            if (curr.children[currChar - 'a'] == null) {
                return false;
            }
            curr = curr.children[currChar - 'a'];
        }
        return true;
    }
    
    public static void main(String[] args) {
        // Your code here
        Trie obj = new Trie();
        String word = "apple";
        obj.insert(word);
        boolean param_2 = obj.search(word);
        System.out.println(param_2);
        boolean param_3 = obj.startsWith("app");
        System.out.println(param_3);
        boolean param_4 = obj.startsWith("apt");
        System.out.println(param_4);
    }
}