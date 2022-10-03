import java.util.LinkedList;
import java.util.Queue;

/*
## Problem2
Longest Word in Dictionary(https://leetcode.com/problems/longest-word-in-dictionary/)

Time Complexity :   O (nk) 
Space Complexity :  O (nk) 
Did this code successfully run on Leetcode :    Yes (720. Longest Word in Dictionary)
Any problem you faced while coding this :       No
 */
// Input: words = ["w","wo","wor","worl","world"]
// Output: "world"

class LongestWord {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        String word;
        
        public TrieNode(){
            children = new TrieNode[26];
            this.word = "";
        }
    }
    
    TrieNode root;
    public void insert(String word) {
        TrieNode curr = root;
        
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
        curr.isEnd = true;
    }
    
    
    // BFS appraoch
    public String longestWord(String[] words) {
        root = new TrieNode();
        
        // create Trie from words
        for(String word: words){
            insert(word);
        }
        
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = null;
        
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i=25; i>=0; i--){
                if(curr.children[i] != null && curr.children[i].isEnd){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}