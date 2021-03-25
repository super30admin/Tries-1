// Time Complexity :
Time complexity of insert, search and startsWith operations in Trie would be 
O(length of the string we are trying to operate on)
// Space Complexity :
Insert Operation : O(length of the string we are trying to operate on)
In the worst case newly inserted word does not share any prfix with 
already inserted words

Search Operation: O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class TrieNode{
    //This is the flag that determines if the word ends at a particular character
    public boolean ending;
    //each node contains the pointers to the next node
    final TrieNode [] children = new TrieNode[26];
    public TrieNode next(char c){
        return children[c - 'a'];
    }
}

public class Trie {
    //Each trie will have a root node
    TrieNode root;
    /** Initialize your data structure here. */

    public Trie() {
       //initalize the root TrieNode
    this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        //Take the root node as current Node
        TrieNode current = root;
        //traverse through the string to create the subsequent TrieNode of the trie
        for(int i = 0; i < word.length();i++){
            //If any of the character of string is not present in Trie create a TrieNode
            if(current.children[word.charAt(i) -  'a'] == null){
                current.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            current = current.next(word.charAt(i));
        }
        /*increment the count as we have created a word that ends with last character of
        the given string
        */
        current.ending = true ;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        //Take the root node as current Node
        TrieNode current = root;
        //iterate through the word and check with the trie of ot contains chars of word
        for(int j = 0; j < word.length(); j++){
            if(current.children[word.charAt(j) - 'a'] == null){
                return false;
            }
        current = current.next(word.charAt(j));  
        }
        return current.ending;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        //Take the root node as current Node
        TrieNode current = root;
        //iterate through the word and check with the trie of ot contains chars of word
        for(int j = 0; j < prefix.length(); j++){
            if(current.children[prefix.charAt(j) - 'a'] == null){
                return false;
            }
        current = current.next(prefix.charAt(j));  
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