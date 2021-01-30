//Problem 76: Implement Trie (Prefix Tree)
//Time Complexity: O(Number of words * word length)
//Space Complexity : O(Number of words * word length); 

/*
 Create a Trie Node comprising of isEnd and children hash map;
 1) Insert: //TC: O(word length) | SC: O(word length) : Keep a current pointer. Iterate over the string to be added into trie. If curr child is null initialise it with trie node. Keep moving the current pointer. Once word traversal is finished set curr pointer isEnd = true;

2) Search  : //TC: O(word length) : Start with root. Iterate over the word and keep moving current pointer. If current pointer becomes null at any point then return false, otherwise at the end return curr.isEnd. It will give what ever the result is 

3) Prefix : //TC: O(word length) : Will compare the whole prefix.  Start with root. Iterate over the word and keep moving current pointer. If current pointer becomes null at any point then return false, otherwise at the end will return true

*/

import java.util.*;
class TrieHashMap {
    //TC: O(Number of words * word length) | SC: O(Number of words * word length)
    class TrieNode{
        private Map<Character,TrieNode> children;
        boolean endChar;
        
        TrieNode(){
            this.children = new HashMap<>();
        }
        
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public TrieHashMap() {
        
        root = new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        //TC: O(word length) | SC: O(word length)
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode children = curr.children.get(ch);
            
            if(children==null){
                 children = new TrieNode();
                 curr.children.put(ch,children);
            }
            
            curr = children;
            
        }
        
        curr.endChar = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        //TC: O(word length)
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode children = curr.children.get(ch);
            
            if(children==null) return false;
            
             curr = children;
        }   
        
        
        return curr.endChar;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        //TC: O(word length)
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            TrieNode children = curr.children.get(ch);
            
            if(children==null) return false;
            
             curr = children;
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