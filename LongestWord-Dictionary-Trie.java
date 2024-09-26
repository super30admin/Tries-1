class Solution {
    
    class TrieNode {
        String str;
        TrieNode[] children;
        
        public TrieNode(){
            str = "";
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public String longestWord(String[] words) {
        
        root = new TrieNode();
        insert_trie(words);
        return large_value(root);
    }
    
    private void insert_trie(String[] words){
        for (String word : words){
            TrieNode node = root;
            for (int x = 0; x < word.length(); x++){
                Character ch = word.charAt(x);
                if (node.children[ch - 'a'] == null){
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.str = word;
        }
    }
    
    private String large_value(TrieNode root){
        String retVal = root.str;
        
        for (int x = 0; x < 26; x++){
            if (root.children[x] != null && root.children[x].str != ""){
                String temp = large_value(root.children[x]);
                if (retVal.length() < temp.length()){
                    retVal = temp;
                }    
            }
        }
        
        return retVal;
    }
}