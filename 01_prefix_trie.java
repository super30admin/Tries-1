/*
We need an array/tree data structure which can have 26 childern
it will be (node, boolean) 
isWord is a boolean flag which will determine the end of word

Approach 1: with array of objects

Time complexity:
1. Insert => O(l)
2. Search => O(l)
3. Prefix => O(l)

Space complexity: O(26 ^ l)

*/

class TrieNode{
    TrieNode[] children; //array of objects which every new TrieNode object will have to store it's children
    boolean isWord;
    
    
    TrieNode(){
        children = new TrieNode[26];
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
            int childIndex = word.charAt(i) - 'a';
            if(curr.children[childIndex] == null){
                curr.children[childIndex] = new TrieNode();
            }
            curr = curr.children[childIndex];
        }
        
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        
        for(int i=0; i<word.length(); i++){
            int childIndex = word.charAt(i) - 'a';
            if(curr.children[childIndex] == null){
                return false;
            }
            curr = curr.children[childIndex];
        }  
        return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        for(int i=0; i<prefix.length(); i++){
            int childIndex = prefix.charAt(i) - 'a';
            if(curr.children[childIndex] == null){
                return false;
            }
            curr = curr.children[childIndex];
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


 