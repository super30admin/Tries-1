// Time Complexity : O(nL), (n is number of words , with longest word length = L)
// Space Complexity : O(nL)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Trie {
    //create a class TrieNode
    class TrieNode {
        //declare array of trieNode (trieChildren)
        TrieNode[] trieChildren; 
        //and isEnd set (end of word or not) (initialized to false by default)
        boolean isEnd;
        
        //constructor
        public TrieNode() {
            //initialize trieChildren array of size 26 (lower case letters)
            trieChildren = new TrieNode[26];
        }
    }

    /** Initialize your data structure here. */
    //declare a TrieNode root
    TrieNode root;
    public Trie() {
        //initalize to a new TrieNode
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        //insert func has a curr TrieNode variable pointing to root
        TrieNode curr = root;
        //for each character in word
        for(int i = 0; i < word.length(); i++) {
            //get the ith char
            char c = word.charAt(i);
            //check if that char is in Trie (if trieNode exists at that array position)
            //array[1] = a ; array[2] = b ... so on 
            //array position represents ascii value of letters
            //then the letter is present
            //if null letter does not exist
            //so create a new trieNode at that array position
            if(curr.trieChildren[c - 'a'] == null) {
                curr.trieChildren[c - 'a'] = new TrieNode();
            }
            //move curr pointer to add the. other letters of the word
            curr = curr.trieChildren[c - 'a'];
        } curr.isEnd = true;   //make the isEnd pointer for last node to be true
        //indicates this is a word in Trie and not a prefix
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        //to search
        //interate the trie
        // //search func has a curr TrieNode variable pointing to root
        TrieNode curr = root;
        //for each character in word
        for(int i = 0; i < word.length(); i++) {
            //check if that char is in Trie (if trieNode exists at that array position)
            //array[1] = a ; array[2] = b ... so on 
            //array position represents ascii value of letters
            //then the letter is present , so move curr position to its children
            //if null letter does not exist so return false
            char c = word.charAt(i);
            if(curr.trieChildren[c - 'a'] == null) {
                return false;
            }
            else {
                curr = curr.trieChildren[c - 'a'];
            }
        }
        return curr.isEnd;    
        //in the end, if all letters are present in trie, return isEnd value
        //if its a word it isEnd will be true
        //if its a prefix isEnd will be false
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        //to check startsWith
        //interate the trie
        //search func has a curr TrieNode variable pointing to root
        TrieNode curr = root;
        //for each character in prefix
        for(int i = 0; i < prefix.length(); i++) {
            //check if that char is in Trie (if trieNode exists at that array position)
            //array[1] = a ; array[2] = b ... so on 
            //array position represents ascii value of letters
            //then the letter is present , so move curr position to its children
            //if null letter does not exist so return false
            char c = prefix.charAt(i);
            if(curr.trieChildren[c - 'a'] == null) {
                return false;
            }
            else {
                curr = curr.trieChildren[c - 'a'];
            }
        }
        return true;   //return true if word exists        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

