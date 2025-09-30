/*
- Trie (Prefix tree) - under the hood its an n-ary tree. Mainly used for searching for a word or a prefix or a suffix.
- We define a trieNode class with character array to maintain the children of the root trieNode and a flag to set true on if a word is found on that level
- Insert: two cases
    Case1: if the character exists at that index, do nothing and increment the word pointer 
    Case2: if the character doesnt exists, create a new trieNode on that level. You dont need to insert the character as we are using index to character mapping so for ex 'c' will always be at index 2 based on ASCII val of 'a' - 'c'
    - once the word is inserted, mark the isEnd var at the curr TrieNode to true
    - TC: O(l) -> length of the word to insert
- Search:
    - iterate character by character  
        - if the trieNode doesnt exist at any of the level before the word ends, return false as the word is not present
        - else, once we are done iterating, return isEnd flag
    - TC: O(l) -> length of the word to search
- Prefix:
    - similar to search but here we dont care about the flag isEnd as prefix might not be a word. 
    - if at any point the reference to trieNode is null, return false
    - once we are done iterating through the word, return true
    - TC: O(l) -> length of the prefix to search

SC: O(n * l) -> n is the number of words to store * length of the each word for storing nodes in trie
*/

class Trie {
    // root of the tree
    TrieNode root;

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        private TrieNode(){
            // new trienode array of 26 elements
            this.children = new TrieNode[26];
        }
    }

    public Trie() {
        //create an empty TrieNode at root level
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            // if curr level children array doesnt contain a trieNode on the particular index, add a new trieNode
            if(curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new TrieNode();
            // increment the level before inserting a new trienode 
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(curr.children[ch - 'a'] == null)
                return false;
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()){
            if(curr.children[ch - 'a'] == null)
                return false;
            curr = curr.children[ch - 'a'];
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