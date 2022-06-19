import java.util.*;

class Solution {
    // BFS Solution
    // Time complexity is O(nk)
    // Space complexity is O(nk)
    // This solution is submitted on leetcode with zero errors
    
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        String word = "";
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    
    public void insertTrie(String word){
        TrieNode curr = root;
        for(int i = 0 ; i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
        curr.word = word;
    }
    
    // Make a global TrieNode
    TrieNode root;
    public String longestWord(String[] words) {
        // Egde case
        if(words == null || words.length == 0) return null;
        
        // Initialize the TrieNode
        root = new TrieNode();
        
        // Make the trienode
        for(String word : words){
            insertTrie(word);
        }
        
        // Start BFS
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode temp = null;
        while(!q.isEmpty()){
            temp = q.poll();
            for(int i = 25; i>=0;i--){
                if(temp.children[i]!=null && temp.children[i].isEnd){
                    q.add(temp.children[i]);
                }
            }
        }
        return temp.word;
    }
}