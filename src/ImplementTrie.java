// Time Complexity : O(n), n = length of the word
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * 
 *
 */
class Trie {
    TreeNode root;
    
    class TreeNode{
        char val;
        boolean isEnd;
        TreeNode[] child;
        
        public TreeNode(){
          child = new TreeNode[26];  
        }
    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();  
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TreeNode prevNode = root;
        
        //start processing remaining characters
        for(int i = 0 ; i< word.length(); i++) {
            char currChar = word.charAt(i);
            
            if(prevNode.child[currChar-'a'] == null) {
                TreeNode currNode = new TreeNode();
                currNode.val = currChar;
                prevNode.child[currChar-'a'] = currNode;
                prevNode = currNode;
            }else {
                prevNode = prevNode.child[currChar-'a'];
            }
        }
        
        //mark end flag true for last character
        prevNode.isEnd = true;
     }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
         char startChar = word.charAt(0);
        TreeNode prevNode = root;
         
        //start checking for remaining characters
        for(int i = 0 ; i< word.length(); i++) {
            char currChar = word.charAt(i);
            
            if(prevNode.child[currChar-'a'] == null) {
                return false;
            } else {
                 prevNode = prevNode.child[currChar-'a'];
            }
        }
        
        //if all char present, check end flag for the last charcter of the word
        return prevNode.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       
        //similar to search, only difference is no need to check end flag for last character
        
        char startChar = prefix.charAt(0);
        TreeNode prevNode = root;
        
        for(int i = 0 ; i< prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            
            if(prevNode.child[currChar-'a'] == null) {
                return false;
            } else {
                 prevNode = prevNode.child[currChar-'a'];
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