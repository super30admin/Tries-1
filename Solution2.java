class Solution {
    private String ans = "";
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        
        for(String word : words){
            trie.insert(word);
        }
        
        dfs(trie.root);
        
        return ans;
    }
    
    public void dfs(TrieNode node){
        if(node==null || node.end == false){
            return;
        }
        
        if(node.word.length() > ans.length()){
            ans = node.word;
        }
        
        for(int i=0; i<26; i++){
            dfs(node.children[i]);
        }
    }
}

class TrieNode{
    TrieNode[] children;
    boolean end;
    String word;
    
    TrieNode(){
        this.children = new TrieNode[26];
    }
}

class Trie{
    TrieNode root;
    Trie(){
        this.root = new TrieNode();
        this.root.end = true;
        this.root.word = "";
    }
    
    public void insert(String word){
        TrieNode node = this.root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(node.children[ch-'a']==null){
                node.children[ch-'a'] = new TrieNode();
            }
            
            node = node.children[ch-'a'];
        }
        
        node.end = true;
        node.word = word;
    }
}
