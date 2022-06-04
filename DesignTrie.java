// Time Complexity :O(L) where L is length of word or prefix
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Trie {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root = new TrieNode();

    public Trie() {

    }

    // to insert, we'll make new TrieNode if there is not children of that char
    // already .then we move our curr
    // pointer to child and make end of word isEnd true
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();

            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    // to search we'll search among trienode's children. if at any point children is
    // null that means
    // we haven't inserted that word so we'll return false there only else will go
    // foreward
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            curr = curr.children[c - 'a'];
            if (curr == null) {
                return false;
            }
        }
        return curr.isEnd;
    }

    // same as search ,in starts with instead of checking end, we'll return if
    // prefix is there and
    // we didn't find any null
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            curr = curr.children[c - 'a'];
            if (curr == null) {
                return false;
            }
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