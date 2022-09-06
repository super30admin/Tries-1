import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(n*k) where n = number of words, k = average length of each string
// Space Complexity : O(l) where l = length of longest word
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//720. Longest Word in Dictionary (Medium) - https://leetcode.com/problems/longest-word-in-dictionary/
class Solution {
    
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        private TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    String result;
    
    private void insert(String word) {
        TrieNode curr = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            
            curr = curr.children[ch-'a'];
        }
        
        curr.isEnd = true;
    }
    
    public String longestWord(String[] words) {
//        root = new TrieNode();
//        result = "";
//        
//        for (String word : words) { // O(n*k) where n = number of words, k = average length of each string
//            insert(word);
//        }
//        
//        backtrack(root, new StringBuilder());
//        return result;
//    }
//    
//    private void backtrack(TrieNode root, StringBuilder curr) {
//        // base
//        if (curr.length() > result.length()) {
//            result = curr.toString();
//        }
//        
//        // logic
//        for (int i = 0; i < 26; i++) {
//            TrieNode child = root.children[i];
//            
//            if (child != null && child.isEnd) {
//                int length = curr.length();
//                
//                // action
//                curr.append((char) ('a'+i));
//                
//                // recurse
//                backtrack(child, curr);
//                
//                // backtrack
//                curr.setLength(length);
//            }
//        }
    	
    	root = new TrieNode();
        
        for (String word : words) { // O(n*k) where n = number of words, k = average length of each string
            insert(word);
        }
        
        TrieNode curr = null;
        
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            curr = queue.poll();
            
            for (int i = 25; i >= 0; i--) {
                if (curr.children[i] != null && curr.children[i].isEnd) {
                    queue.add(curr.children[i]);
                }
            }
        }
        
        return curr.word;
    }
}