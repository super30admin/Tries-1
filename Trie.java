// Time Complexity : O(l)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class TrieNode {
    // to check end of the word
    boolean isEnd;
    // to store children
    TrieNode[] children;

    // constructor
    TrieNode() {
        // there will be 26 children at each node
        children = new TrieNode[26];
    }
}

class Main {
    private TrieNode root;

    public Main() {
        root = new TrieNode();
    }

    public void insert(String word) {
        // current TrieNode
        TrieNode curr = root;
        // traverse through each character in a word and create a new child if not
        // existed
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        // current TrieNode
        TrieNode curr = root;
        // traverse through each character in a word and check there character is there
        // in a trie
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // if there is no character in a trie we return false;
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        // return is it end?
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        // current TrieNode
        TrieNode curr = root;
        // traverse through each character in a word and check there character is there
        // in a trie
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            // if there is no character in a trie we return false;
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.insert("apple");
        System.out.println(main.search("apple"));
        System.out.println(main.startsWith("appe"));
    }
}