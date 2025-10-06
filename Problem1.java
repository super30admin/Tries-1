// Time Complexity : O(l) insert, O(l) for search, O(l) for prefix where l is the length of the word
// Space Complexity : O(nl) where n is the number of words
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Implemented the TrieNode class to keep track of current and all children nodes. Initialized the Trie using root and using the same root for traversing the Trie for all methods.
 */
class Trie {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            // assuming english lower case letters only
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        // initializing the root
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // node doesn't exist for the current letter
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            // move the pointer to next letter
            curr = curr.children[ch - 'a'];
        }

        // the word ends at this character
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // node doesn't exist for current letter
            if (curr.children[ch - 'a'] == null) return false;
            curr = curr.children[ch - 'a'];
        }

        // reached the end for the word to search. Check if there is any word ending at this letter in trie
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (curr.children[ch - 'a'] == null) return false;
            curr = curr.children[ch - 'a'];
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