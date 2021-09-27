//https://leetcode.com/problems/implement-trie-prefix-tree/submissions/
class TrieNode{
    boolean isend;
    TrieNode[] children;
    
    public TrieNode(){
        children = new TrieNode[26];    
    }
}
class Trie {
    
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    //time complexity : N
    //space complexity : N
    public void insert(String word) {
        TrieNode curr = root;
        char c;
        for(int i =0;i<word.length();i++){
            c = word.charAt(i);
            if(curr.children[c-'a']== null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isend = true;
        
    }
    //time complexity : N
    //space complexity : 1
    public boolean search(String word) {
        TrieNode curr = root;
        char c;
        for(int i =0;i<word.length();i++){
            c = word.charAt(i);
            if(curr.children[c-'a']== null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isend;
        
    }
    //time complexity : N
    //space complexity : 1
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        char c;
        for(int i =0;i<prefix.length();i++){
            c = prefix.charAt(i);
            if(curr.children[c-'a']== null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        
        return true;
        
    }
}