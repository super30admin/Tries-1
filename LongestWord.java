// Time Complexity : O(n*m) where n is the length of word array, m is the length of longest word length
// Space Complexity : O(n*m) for building the trie tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    class TrieNode{
        String isWord;
        TrieNode[] children;
        
        public TrieNode(){
            isWord = "";
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    String result = "";
    
    public void insert(String[] words){
        for(String s:words){
            TrieNode curr = root;
            for(int i=0;i<s.length();i++){
               if(curr.children[s.charAt(i)-'a'] == null)
                   curr.children[s.charAt(i)-'a'] = new TrieNode();
                curr = curr.children[s.charAt(i)-'a'];
            }
            curr.isWord = s;
        }
    }
    
    public void dfs(TrieNode root){
        TrieNode curr = root;
        if(curr.isWord.length() > result.length()) result = curr.isWord;
        for(int i=0;i<26;i++){
            if(curr.children[i] != null && curr.children[i].isWord != "")
                dfs(curr.children[i]);
        }
    }
    public String longestWord(String[] words) {
        // insert word list to build trie tree
        root = new TrieNode();
        insert(words);
        // traverse thru trie and find the longest word
        // use dfs
        dfs(root);
        return result;
    }
}
