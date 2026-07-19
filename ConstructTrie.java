// Time Complexity : o(n) where n is the length of the word being inserted or searched
// Space Complexity :  o(n) where n is the length of the word being inserted or searched
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// This is a standard implementation of a Trie data structure. 
// It consists of a root node and each node has an array of children representing the 26 lowercase English letters.
//  The insert method adds words to the Trie, the search method checks if a word exists in the Trie, and the startsWith method checks if there is any word in the Trie that starts with a given prefix.
//  Each operation traverses the Trie based on the characters of the input word or prefix, making it efficient for these types of queries.
// The time complexity for each operation is O(n), where n is the length of the word being inserted or searched, and the space complexity is also O(n) due to the storage of nodes in the Trie.
class Trie {

    TrieNode root;

    class TrieNode {

        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr = root;

        for (char c : word.toCharArray()) {

            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }

            curr = curr.children[c - 'a'];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {

        TrieNode curr = root;

        for (char c : word.toCharArray()) {

            if (curr.children[c - 'a'] == null) {
                return false;
            }

            curr = curr.children[c - 'a'];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {

        TrieNode curr = root;

        for (char c : prefix.toCharArray()) {

            if (curr.children[c - 'a'] == null) {
                return false;
            }

            curr = curr.children[c - 'a'];
        }

        return true;
    }
}