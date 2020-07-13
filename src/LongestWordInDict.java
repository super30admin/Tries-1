// Time Complexity : O(nl + n) , l- avg length of word, n= number of words , nl - time taken to build trie, n - iterate of queue at level order (level order will have max n characters)
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * create trie out of all nodes, maintain parent node pointer in the trie
 * start processing all the words, one char at a time (level order), in order large char first ,
 * last character from the queue, will give last char for the longest word and large to small character order
 * maintain the smaller lexicographical condition, now climb up from the last node till root to find whole word
 * 
 *https://leetcode.com/problems/longest-word-in-dictionary/
 */
class Solution {
    TreeNode root;
    
    class TreeNode{
        char val;
        boolean isEnd;
        TreeNode parent;
        TreeNode[] child;
        
        public TreeNode(){
          child = new TreeNode[26];  
        }
    }
    /** Initialize your data structure here. */
    public Solution() {
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
                currNode.parent = prevNode;
                prevNode = currNode;
            }else {
                prevNode = prevNode.child[currChar-'a'];
            }
        }
        
        //mark end flag true for last character
        prevNode.isEnd = true;
     }
     
    public String longestWord(String[] words) {
        
        if(words == null || words.length == 0) return "";
        Solution sc = new Solution();
        
        for(String word:words){
            sc.insert(word);
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        //add to queue, all available characters at root node
        //process from end, to find lexicographically small word
        for(int i=25; i>=0 ; i--){
            TreeNode node = sc.root.child[i];
            //only add current node if its end flag true
            if(node != null && node.isEnd){
                q.add(node);
            }
        }
        
        TreeNode last = null;
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            last = curr;
             //process from end, to find lexicographically small word
                for(int i=25; i>=0 ; i--){
                TreeNode node = curr.child[i];
                    
                //only add current node if its end flag true
                if(node != null && node.isEnd){
                    q.add(node);
                }
            }
        }
        
        //last node from the queue, will be the node from the lexicographically longest word
        TreeNode curr = last;
        StringBuilder sb = new StringBuilder();
        
        //once we find last node, climb up till root and form our word
        while(curr.parent != null) {
           sb.append(Character.toString(curr.val));
            curr = curr.parent;
        }
        
        //reverse word since its been formed from bottom up 
        return sb.reverse().toString();
    }
}