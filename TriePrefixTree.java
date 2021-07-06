
/*
TC : O(N) for insert, search, startsWith as for each operation we will iterate over the characters of the word
SC :  it will be O(26^k) for creating a dictionary of N words where k is the maximum length of the word.
LeetCode : yes
Problems : No
 */

/**
 * Here, we basically create a Tree with each node having an array of length 26 to keep
 * a track of what letter is present along a particular path.
 * Also, we have a boolean variable isEnd to keep a note of existence of a word along a particular path.
 * <p>
 * While insertion, we create a new TrieNode array for each of the characters present and at the last character,
 * we mark the isEnd flag as True.
 * <p>
 * While searching, we iterate over the word and if at any point we find that the children at location
 * char - 'a' is null, that means the word doesnt exist. If we reach the end of word, then we check for
 * isEnd to verify if the word exists
 * <p>
 * For startsWith, we perform similar operation to search. The only difference being if we reach the end of the
 * word, that means we should return true as there exists a word that startswith the given word
 */


public class TriePrefixTree {

    class TrieNode {

        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public TriePrefixTree() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }

        curr.isEnd = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}
