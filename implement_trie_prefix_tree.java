// Time Complexity : O(l), where l is the length of the word
// Space Complexity : O(l), where l is the length of the word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Correct me on the space and time complexity

//Three liner explanation of your code in plain English
//1. Create a TrieNode class containing a boolean isEnd and and an TrieNode array of length 26/
//2. For creating the trie for a word, iterate over the characters of the word and a new node in the trie at
        //index as current character-'a', Marking the isEnd of the last characternode as True (to mark the 
        //end of the word)
//2. Similary for searching the word in the trie, caclucte the index like above for each character and search in 
        //trie , in the end make sure that isEnd for the last character is True
//3. Similarly for searching prefix calculate the index like above for each character and search in the trie
        //this time the isEnd for the last character need not be True , as there can be more characters in the
        //word

// Your code here along with comments explaining your approach

class Trie {
   //TrieNode class
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
        
    }
    //head that holds the trieNode
     TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        //assign the root to a temp trieNode
        TrieNode curr = root;
        
        //add each character of the word to the Trie
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
             curr = curr.children[c-'a'];
        }
        //make the last's triNode's isEnd as true, marking the end of the word
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        //assign the root to a temp trieNode
        TrieNode curr = root;
        //search each character of the word to the Trie
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        //return if the word was found as a whole
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        //assign the root to a temp trieNode
        TrieNode curr = root;
        //search each character of the prefix to the Trie
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        //return true if all the prefix characters are found
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