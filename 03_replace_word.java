// Approach 1 : using tries

/*
 * Time Complexity: O(rl + 2k) //rl is to create a trie and 2k is to iterate through each word in the split and search
 * Space Complexity: O(rl + k) //k is to store the split string
 */

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String root : dictionary){
            trie.insert(root);
        }
        
        String[] words = sentence.split(" ");
        
        for(int i=0; i<words.length; i++){
            String word = words[i];
            String root = trie.shortestWord(word);
            words[i] = root==null ? word : root;
        }
        
        return  String.join(" ", words);
        
    }
    
}

class TrieNode{
    private TrieNode[] children;
    private boolean isWord;
    
    public TrieNode(){
        children = new TrieNode[26];
    }
    
    public TrieNode createAndGetChild(char ch){
        int index = ch - 'a';
            if(this.children[index]==null){
                this.children[index] = new TrieNode();
            }
        return this.children[index];       
    }
    
    public void setWord(){
        this.isWord = true;
    }
    
    public boolean isWord(){
        return this.isWord;
    }
    
    public TrieNode getChild(char ch){
        return this.children[ch-'a'];
    }
    
}

class Trie{
    TrieNode root;
    
    Trie(){
        root = new TrieNode();
    }
    
    
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            curr = curr.createAndGetChild(ch);
        }
        curr.setWord();
    }
    
    public String shortestWord(String word){
        TrieNode curr = root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            curr = curr.getChild(ch);
            if(curr == null){
                break;
            }
            if(curr.isWord()){
                return word.substring(0,i+1);
            }
        }
        return null;
    }
}