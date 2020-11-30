//https://leetcode.com/problems/implement-trie-prefix-tree/
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach:
class Trie {
    Trie[] children = new Trie[27];
    /** Initialize your data structure here. */
    public Trie() {
        for(int i = 0;i<children.length;i++)
            children[i] = null;

    }
    Trie root = null;
    // Time Complexity : O(n) -> length of String
    // Space Complexity : O(m*n) -> n-> length of string m-> size of array
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int index;
        int level = 0;
        if(root == null)    root = new Trie();
        Trie current = root;
        for(int i = 0;i<word.length();i++){
            index = word.charAt(i) - 'a';
            if(current.children[index] == null)
                current.children[index] = new Trie();
            current = current.children[index];
        }
        current.children[26] = new Trie();
    }

    // Time Complexity : O(n) -> length of String
    // Space Complexity : O(1) -> already existing tries
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int index;
        if(root == null)    return false;
        Trie current = root;
        for(int i = 0;i<word.length();i++){
            index = word.charAt(i) - 'a';
            if(current.children[index] == null)
                return false;
            current = current.children[index];
        }
        if(current.children[26] == null)
            return false;
        return true;
    }
    // Time Complexity : O(n) -> length of String
    // Space Complexity : O(1) -> already existing tries
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int index;
        if(root == null)    return false;
        Trie current = root;
        for(int i = 0;i<prefix.length();i++){
            index = prefix.charAt(i) - 'a';
            if(current.children[index] == null)
                return false;
            current = current.children[index];
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
