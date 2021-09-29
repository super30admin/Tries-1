// Time Complexity : O(m), where m = size of the word
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes

class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) { // TC: O(m), SC: O(m)
        TrieNode curr = root;
        char c;
        for(int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) { // TC: O(m), SC: O(1)
        TrieNode curr = root;
        char c;
        for(int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        char c;
        for(int i = 0; i < prefix.length(); i++) {
            c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}