/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

// Time Complexity : insert(): O(L), search(): O(L), startsWith(): O(L)
// Space Complexity : insert(): O(L), search(): O(1), startsWith(): O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Trie {

    TrieNode root;

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.isEnd = false;
            children = new TrieNode[26];
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null)
                return false;
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()) {
            if(curr.children[c-'a'] == null)
                return false;
            curr = curr.children[c-'a'];
        }
        return true;
    }
}