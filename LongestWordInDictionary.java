//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    
    class TrieNode{
        TrieNode children[];
        String word;
        
        public TrieNode(){
            children = new TrieNode[26];
            word = "";
        }
    }
    
    private TrieNode root;
    private String result = "";
    
    public String longestWord(String[] words) {
        
        root = new TrieNode();
        
        insert(words);
        dfs(root);
         
        return result;
    }
    
    private void insert(String words[]){
        
        for(String word: words){
            
            TrieNode curr = root;
            
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                
                if(curr.children[ch - 'a'] == null){
                    curr.children[ch - 'a'] = new TrieNode();
                }
                
                curr = curr.children[ch - 'a'];
                
            }
            
            curr.word = word;
            
        }
    }
    
    private void dfs(TrieNode root){
        
        if(root.word.length() > result.length()){
            result = root.word;
        }
        
        for(int i = 0; i < 26; i++){
            
            if(root.children[i] != null && root.children[i].word != ""){
                dfs(root.children[i]);
            }
            
        }
        
    }
}
