/*
* Approach:
*  1. Create TrieNode with isEnd and children(Array of TrieNode).
        Start with root.
* 
*  2. Insert the word by iterating over word and
         create the TrieNode at char children.
* 
*  3. Searching the word can be done by iterating over the trie,
        and once the last char is checked, check isEnd is true or not.

        Starts with follow the same pattern of searchWord.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: 
    insert, search: O(L)
    L - length of the word.
    prefix: O(P)
    P - length of prefix
* 
* Space Complexity: O(W)
    W - words in trie.
* 
*/

class Trie {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.isEnd = false;
            children = new TrieNode[26];
        }
    };

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for (int index = 0; index < word.length(); index++) {
            char ch = word.charAt(index);

            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for (int index = 0; index < word.length(); index++) {
            char ch = word.charAt(index);

            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (int index = 0; index < prefix.length(); index++) {
            char ch = prefix.charAt(index);

            if (curr.children[ch - 'a'] == null) {
                return false;
            }
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