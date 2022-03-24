class TrieNode{
        TrieNode[] children;
        boolean end;
        
        public TrieNode(){
            this.children = new TrieNode[26];
            this.end = false;
        }
}

class Trie {
    
    private TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();    
    }
    
    public void insert(String word) {
        TrieNode node = this.root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(node.children[ch-'a']==null){
                node.children[ch-'a'] = new TrieNode();
            }
            
            node = node.children[ch-'a'];
        }
        
        node.end = true;
    }
    
    public boolean search(String word) {
        TrieNode node = this.root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(node.children[ch-'a']==null){
                return false;
            }
            
            node = node.children[ch-'a'];
        }
        
        return node.end;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            
            if(node.children[ch-'a']==null){
                return false;
            }
            
            node = node.children[ch-'a'];
        }
        
        return true;
    }
    
    public String getPrefixWord(String word){
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(node.children[ch-'a']==null){
                return null;
            }
            
            node = node.children[ch-'a'];
            
            if(node.end){
                return word.substring(0, i + 1);
            }
        }
        
        return null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        
        for(String rootword : dictionary){
            trie.insert(rootword);
        }
        
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for(String word : words){
            
            if(res.length() > 0){
                res.append(" ");
            }
            
            String prefixWord = trie.getPrefixWord(word);
            if(prefixWord == null){
                res.append(word);
            }else{
                res.append(prefixWord);
            }
        }
        
        return res.toString();
        
    }
    
    
}
