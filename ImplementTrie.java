// Time Complexity :-
//      startsWith() - O(n)
//      search() - O(n)
//      insert() - O(n)
//
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We create a class TrieNode to keep track of the different possible words.
*/

class Trie {

    class TrieNode{
        TrieNode [] children;
        boolean isEnd;
        String path;
        public TrieNode(){
            this.children = new TrieNode[26];
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
        for (int i=0; i<word.length(); i++){
            if (curr.children[word.charAt(i) - 'a'] == null)
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        int index = 0;
        while (index < word.length()){
            if (curr.children[word.charAt(index)-'a'] == null) return false;
            curr = curr.children[word.charAt(index)-'a'];
            index++;
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int index = 0;
        while (index < prefix.length()){
            if (curr.children[prefix.charAt(index)-'a'] == null) return false;
            curr = curr.children[prefix.charAt(index)-'a'];
            index++;
        }
        return true;
    }
}
