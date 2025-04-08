// TC = Insert - O(L), Search - O(L), startsWith - O(L)
// SC = O(1) for all 3 functions, for C^r O(n * L * 26) ~ O(n * L) n = no. of words, L = length of longest word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Trie {
    class TrieNode {
        boolean isEnd; // end of the word
        TrieNode[] children;
        TrieNode() { // C^r
            isEnd = false;  
            children = new TrieNode[26]; // 1 trie is made up of 25 TrieNodes
        }
    }
    TrieNode root; // object
    public Trie() { // C^r
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null) { // checking if already exists
                curr.children[c - 'a'] = new TrieNode(); // if not, create
            }
            curr = curr.children[c - 'a']; // moving curr to next curr in children
        }
        curr.isEnd = true; // mark the last char as end
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd; // if the char is last check and return
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return true; // prefix exists
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */