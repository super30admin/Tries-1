class Solution {
    // DFS Solution
    // Time complexity is O(nk)
    // Space complexity is O(nk)
    // This solution is submitted on leetcode with zero errors
    
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        Character ch;
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
        curr.ch = word.charAt(word.length()-1);
    }
    
    // Make a global TrieNode
    TrieNode root;
    StringBuilder result;
    public String longestWord(String[] words) {
        // Egde case
        if(words == null || words.length == 0) return null;
        
        // Initialize the TrieNode
        root = new TrieNode();
        
        // Make the trienode
        for(String word : words){
            insertTrie(word);
        }
        result = new StringBuilder();
        // Start DFS
        DFS(root, new StringBuilder());
        return result.toString();
    }
    
    public void DFS(TrieNode curr, StringBuilder str){
        
        // Egde case
        if(result.length() <= str.length()){
            result = new StringBuilder(str);
        }
        
        // Logic
        for(int i = 25; i>=0;i--){
            if(curr.children[i]!=null && curr.children[i].isEnd){
                // action 
                str.append(curr.children[i].ch);
                // Recurse
                DFS(curr.children[i], str);
                // backtrack
                str.setLength(str.length() -1);
            }
        }
    }
}