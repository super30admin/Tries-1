// Time Complexity : O(n); n is the length of word to be inserted, searched
// Space Complexity : O(n); n is the maximum length of the word. for each character we'll be having 26 memory allocations, however it should be ignored being a constant.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : 
// 1. Create a trie datastructure which will hold array of 26 characters and whose children will subsequently have a similar structure.
// 2. For inserting a character, we just need to check if value at the corresponding index exists or not. If not, then another TrieNode structure is created at that index indicating a character insert.
// 3. For searching we just need to keep checking that the index corresponding to current character is not null.
// 4. Once search is finished, whether it is complete or not is indicated by the boolean marker.
// 5. Difference between search and prefix is that prefix will always return true if it has successfully searched the given word.

class Trie {

    /** Initialize your data structure here. */
    private class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null)
                return false;
            curr = curr.children[ch-'a'];
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(curr.children[ch-'a'] == null)
                return false;
            curr = curr.children[ch-'a'];
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

