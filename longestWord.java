// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    
    class TrieNode{
        TrieNode child [];
        String word ;
        public TrieNode(){
            child = new TrieNode[ 26 ];
            word = "";
        }
    }
    private TrieNode root;
    private String result="";
    public String longestWord(String[] words) {
        root = new TrieNode();
        insert(words);
        dfs(root);

        return result;
        
    }
    
    private void insert(String[] words){
        
        for(String str : words){
            TrieNode curr =root;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                if(curr.child[ch - 'a'] == null){
                    curr.child[ch-'a'] = new TrieNode();
                }
                curr = curr.child[ch - 'a'];
            }
            curr.word=str;
        }
    }
    
    private void dfs(TrieNode root){
        //base 
        
        if(root.word.length() > result.length()){
            result = root.word;
        }
        
        for(int i = 0; i < 26; i++ ){
            if(root.child[i] != null && root.child[i].word != ""){
                dfs(root.child[i]);
            }
        }
    } 
}
