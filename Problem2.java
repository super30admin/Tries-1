
//Problem2
//Longest Word in Dictionary(https://leetcode.com/problems/longest-word-in-dictionary/)
// time - O(n) space -  O(n)
//BFS + Trie
class Solution {
    TrieNode root;
    
    Solution(){
        root = new TrieNode();
    }
     /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
         curr.word = word;
    }

    public String longestWord(String[] words) {
        for(String word: words){
            insert(word);
        }
        TrieNode curr = root;
        Queue<TrieNode> q = new LinkedList<>();
        q.add(curr);
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i >= 0; i--){
                if(curr.children[i - 0] != null && curr.children[i].word != null){
                    q.add(curr.children[i]);
                }
            }
        }
        
        return curr.word;
    }
}

class TrieNode{
    TrieNode[] children;
    String word;

    /** Initialize your data structure here. */
    public TrieNode() {
         children = new TrieNode[26];
    }
}