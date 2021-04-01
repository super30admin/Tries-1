class Solution {
    class TrieNode {
        TrieNode[] children;
        String word;
        
        public TrieNode(){
            children = new TrieNode[26];
            word="";
        }
    }
    
    private TrieNode root;
    private String output = "";
    
    private void insert(String[] words){
        for(String word: words){
            TrieNode curr = root;
            for(char ch: word.toCharArray()){
                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr = curr.children[ch-'a'];
            }
            curr.word = word;
        }
    }
    
    private void dfs(TrieNode node){
        //basecase
        if(node.word.length() > output.length()){
            output = node.word;
        }
        
        for(int i = 0; i < 26; i++){
            if(node.children[i] != null && node.children[i].word != ""){
                dfs(node.children[i]);
            }
        }
    }
    
    public String longestWord(String[] words) {
        
        root = new TrieNode();
        
        //insert build dict
        insert(words);
        
        //dfs
        dfs(root);
        return output;
    }
}

//Time Complexity: O(m) m -> sum of length of all the words
//Space Complexity: O(m)