// Time Complexity : O(n) 
// Space Complexity : O(n) n is number of characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    
    private TrieNode root;
    private String res = "";

    public String longestWord(String[] words) {  
        if(words == null) 
            return res;
        
        root = new TrieNode();
        for(String word : words){
            insert(word);
        }
        dfs(root);
        return res;
    }
    
    private void dfs(TrieNode node){
        if(node.word != null){
            if(node.word.length() > res.length()){
                res = node.word;
            }else if(node.word.length() == res.length() && node.word.compareTo(res) < 0){
                res = node.word;
            }
        }
        
        for(int i=0; i<26; i++){
            if(node.children[i] != null && node.children[i].word!=null){
                dfs(node.children[i]);
            }
        }
    }
    
    private void insert(String word){ 
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word=word;
    }
}

class TrieNode{
    TrieNode[] children;
    String word;
    
    TrieNode(){
        children = new TrieNode[26];
    }
}