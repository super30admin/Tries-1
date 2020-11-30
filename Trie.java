/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Runs on Leetcode: Yes
 * Problems: None 
 */
class Trie {
    
    /**TreeNode class */
    class TreeNode {
        TreeNode[] children;
        boolean isWordEnd;
        
        TreeNode() {
            this.children = new TreeNode[26];
            this.isWordEnd = false;
        }
    }
    
    TreeNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TreeNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode cursor = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(cursor.children[index] == null) cursor.children[index] = new TreeNode();
            cursor = cursor.children[index];
            if(i == word.length() - 1) cursor.isWordEnd = true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode cursor = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(cursor.children[index] == null) return false;
            cursor = cursor.children[index];
        }
        
        return cursor.isWordEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode cursor = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(cursor.children[index] == null) return false;
            cursor = cursor.children[index];
        }
        
        return true;
    }
}