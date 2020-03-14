// Time Complexity : Insert, Search and StartsWith: O(k), for each query, where k is length of string. 
// Space Complexity : O(n*k), n strings, k is length of largest string.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve before class


// Your code here along with comments explaining your approach

class Trie {

    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode cursor = root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(cursor.children[ch - 'a'] == null){
                cursor.children[ch - 'a'] = new TrieNode();
            }
            
            cursor = cursor.children[ch - 'a'];
        }
        
        cursor.isEndOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode cursor = root;
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            
            if(cursor.children[c - 'a'] == null){
                return false;
            }
            cursor = cursor.children[c - 'a'];
        }
        
        return cursor.isEndOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cursor = root;
        
        for(int i=0; i< prefix.length(); i++){
            char c = prefix.charAt(i);
            
            if(cursor.children[c - 'a'] == null){
                return false;
            }
            
            cursor = cursor.children[c - 'a'];
        }
        
        return true;
    }
}


class TrieNode{
    //children
    TrieNode[] children;
    
    //marker
    boolean isEndOfWord;
    
    //constructor
    public TrieNode(){
        children = new TrieNode[26];
    }
}

