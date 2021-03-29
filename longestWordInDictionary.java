//Time Complexity: O(sum(len(stringsInArr)) 
//Space Complexity: O(sum(len(s))


class Solution {
    
    class TrieNode {
        TrieNode[] children;
        String word;
        
        public TrieNode(){
            children = new TrieNode[26];
            word = "";
        }
    }
    
    TrieNode root;
    String output = "";
    
    public String longestWord(String[] words) {
        //sanity check
        if(words == null || words.length == 0){
            return "";
        }
        root = new TrieNode();
        
        //insert. buildDict
        insert(words);
        
        //dfs
        dfs(root);
        
        return output;
    }
    
    private void insert(String[] words){
        
        for(String w : words){
            TrieNode curr = root;
            for(char ch : w.toCharArray()){
                if(curr.children[ch - 'a'] == null){
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr= curr.children[ch - 'a'];
            }
            curr.word = w;
        }
        
    }
    
    private void dfs(TrieNode node){
        if(node.word.length() > output.length()){
            output = node.word;
        }
        
        for(int i = 0;i < 26;i++){
            if(node.children[i] != null && node.children[i].word != "")//base case
                dfs(node.children[i]);
        }
    }
    
}