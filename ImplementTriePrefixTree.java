//Time Complexity: O(nl), dictionary of words with n words having avg length of l.
//Space Complexity: O(nl), Trie Space 

class Trie {
    class TrieNode {
        TrieNode[] children; // Array Implementation of Tries
        boolean isEnd;

        public TrieNode() { // constructor
            children = new TrieNode[26]; // 26 because of 26 lower case alphabets
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root; // intialising curr to root
        for (int i = 0; i < word.length(); i++) { // iterating over the word character by character
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) { // checking if char c is present at its index
                curr.children[c - 'a'] = new TrieNode(); // if not present, create a new TrieNode at that index
            }
            curr = curr.children[c - 'a']; // changing curr to the current node.
        }
        curr.isEnd = true; // setting the boolean variable to true to mark end of the word in the Trie.

    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) { // iterating over the word character by character
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return false; // word not present
            }
            curr = curr.children[c - 'a']; // else move to its child (next node-char in word)
        }
        return curr.isEnd;

    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) { // iterating over the word character by character
            char c = prefix.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return false; // prefix not present
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */