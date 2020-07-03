/*

Time and Space: O(N)

Passed all test cases on leetcode

Approach:
Here we will be using a object of class which consists of variables that will tell whether the node is a end of a word or not.
Also we will have an array for 26 letters and the moment we will be inserting characters or will be having the next character in 
the word we will make a new node at the index for a particular character in the array and the moment we will be at the last character
we will make the variable(which tells whether we are at the last character or not) true. Then for searching for the particular word or 
prefix we can iterate over the trie till the time either we are at the end and have not found the prefix(word) or we have found the prefix or word.

*/
class Trie {
    
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++) {
            char c = prefix.charAt(i);
            if(curr.children[c-'a']==null) {
                return false;
            }
            curr = curr.children[c-'a'];
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