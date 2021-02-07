// Time Complexity : O(n) where n is the longest word in Trie.
// Space Complexity : O(n) where n is the longest word in Trie.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Maitain children nodes for each char a-z & if the trie node is an end node or not.

class Trie {
    class TrieNode{
        TrieNode[] children;
        boolean bEnd;
        public TrieNode() {
            this.children = new TrieNode[26];
            bEnd = false;
        }

    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if(cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.bEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if(cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c-'a'];
        }
        return cur.bEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if(cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c-'a'];
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
