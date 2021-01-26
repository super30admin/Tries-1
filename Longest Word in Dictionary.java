// Time Complexity : O(W), for building trie, in worst case traversing all the trie, W is sum of chars across all words
// Space Complexity : O(W), for trie

// Your code here along with comments explaining your approach
// form trie, explore trie to look for longestWord where each substring has isEnd is true

class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    
    public TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}

class Trie{
    TrieNode root;
    
    public Trie(String[] words){
        this.root = new TrieNode();
        
        for(String word : words){
            addWord(word);    
        }
    }
    
    private void addWord(String word){
        TrieNode cur = root;
        
        for(char ch : word.toCharArray()){
            if(cur.children[ch-'a']==null){
                cur.children[ch-'a'] = new TrieNode();
            }
            
            cur = cur.children[ch-'a'];
        }
        
        cur.isEnd = true;
    }
    
    int maxLength;
    String longestString;
    
    private void helper(TrieNode node, StringBuilder sb){
        if(sb.length()>maxLength){
            this.longestString = sb.toString();
            this.maxLength = sb.length();
        }
        
        for(int i=0; i<26; i++){
            TrieNode child = node.children[i]; 
            if(child!=null && child.isEnd){
                sb.append((char)(i+'a'));
                helper(child, sb);
                sb.deleteCharAt(sb.length()-1);                
            }
        }
    }
    
    public String getLongestWord(){
        this.maxLength = 0;
        this.longestString = null;
        
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        
        return this.longestString;
    }
}

class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie(words);
        
        return trie.getLongestWord();
    }
}
