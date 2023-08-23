//Approach 1 Normal Trie
/*
 * Time Complexity = O(nl + nl) (1st nl is to create a trie next is to iterate through each word of length l)
 * Space Complexity = 26 ^ l (max posible words)
 */
class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        
        for(String word: words){
            trie.insert(word);
        }
        
        String ans = "";
        for(String word: words){
            if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans)<0)){ // no benefit of this condition in worst case possibility but overall it is still better
                if(trie.allPrefixMatch(word)){
                    ans = word;
                }
            }
            
        }
        return ans;
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
    
    public boolean allPrefixMatch(String word){
        TrieNode curr = root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            curr = curr.getChild(ch);
            if(curr == null || !curr.isWord()){
                return false;
            }
        }
        return true;
    }
}

/*
Approach 2: with Map of objects

Time complexity:
1. Insert => O(l)
2. Search => O(l)
3. Prefix => O(l)

Space complexity: 26 ^ l

*/

class TrieNode{
    Map<Character, TrieNode> children; //array of objects which every new TrieNode object will have to store it's children
    boolean isWord;
    
    
    TrieNode(){
        children = new HashMap<>();
    }
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch)){
                return false;
            }
            curr = curr.children.get(ch);
        }  
        return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!curr.children.containsKey(ch)){
                return false;
            }
            curr = curr.children.get(ch);
        }  
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

 //Approach 2 : DFS
/*
 * Time Complexity: nl 
 * Space Complexity: nl
 */


class Solution {
    String ans;
    Trie trie;
    
    
    public String longestWord(String[] words) {
        trie = new Trie();
        
        for(String word: words){
            trie.insert(word);
        }
        ans = "";
        dfs(trie.root);
        
        return ans;
    }
    
    public void dfs(TrieNode node){
        //base case
        if(node == null || (node!=trie.root && !node.isWord())){
            return;
        }
        
        //recursion
        if(node!= trie.root && node.getWord().length() > ans.length()){
            ans = node.getWord();
        }
        
        for(TrieNode child : node.getChildren()){
            dfs(child);
        }
    }
}

class TrieNode{
    private TrieNode[] children;
    private String word;
    
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
    
    public void setWord(String word){
        this.word = word;
    }
    
    public boolean isWord(){
        return this.getWord() != null;
    }
    
    public String getWord(){
        return this.word;
    }
    
    public TrieNode getChild(char ch){
        return this.children[ch-'a'];
    }
    
    public TrieNode[] getChildren(){
        return this.children;
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
        curr.setWord(word);
    }
    
    public boolean allPrefixMatch(String word){
        TrieNode curr = root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            curr = curr.getChild(ch);
            if(curr == null || !curr.isWord()){
                return false;
            }
        }
        return true;
    }
}