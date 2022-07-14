// Time Complexity : search and startWith method - O(n) O(nxl) - n is the number of times searched and l is the length of the word 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//208. Implement Trie (Prefix Tree)
//https://leetcode.com/problems/implement-trie-prefix-tree/


class Trie {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            // this.isEnd = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null)
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            curr = curr.children[word.charAt(i) - 'a']; // how to go to the node it is pointing to
        }
        curr.isEnd = true;
    }

    public boolean search(String word) { // time: O(nxl) - n is the number of times searched and l is the length of the
                                         // word, space: O(1)
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null)
                return false;
            curr = curr.children[word.charAt(i) - 'a']; // how to go to the node it is pointing to
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) { // time: O(nxl) - n is the number of times searched and l is the length
                                               // of the word, space: O(1)
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (curr.children[prefix.charAt(i) - 'a'] == null)
                return false;
            curr = curr.children[prefix.charAt(i) - 'a']; // how to go to the node it is pointing to
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