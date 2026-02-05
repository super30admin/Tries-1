// Time Complexity : Insert (O(L)), Search(O(L)), l is length of the input string
// Space Complexity : Insert (O(1)), Search(O(1))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode head = root;
        for (int i = 0; i < word.length(); i++) {
            int currChar = word.charAt(i) - 'a';
            if (head.children[currChar] == null) {
                head.children[currChar] = new TrieNode();
            }
            head = head.children[currChar];
        }
        // Insert the word and mark is end true to indicate the last character of the word
        head.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode head = root;
        for (int i = 0; i < word.length(); i++) {
            int currChar = word.charAt(i) - 'a';
            if (head.children[currChar] == null) {
                return false;
            }
            head = head.children[currChar];
        }
        return head.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode head = root;
        for (int i = 0; i < prefix.length(); i++) {
            int currChar = prefix.charAt(i) - 'a';
            if (head.children[currChar] == null) return false;
            head = head.children[currChar];
        }
        return true;
    }

    class TrieNode {
        boolean isEnd;
        // Store the children in an array for quick search
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}


