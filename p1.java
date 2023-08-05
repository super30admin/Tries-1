// Time Complexity : insert - O(l) where l is the length of the word
//Search - O(l) where l is the length of the word
//startsWith - O(l) where l is the length of the prefix
//If we consider length to be constant
// Insert - O(1)
//Search - O(1)
// startsWith - O(1)

// Space Complexity :insert - O(l) where l is the length of the word
///Search - O(1)
// startsWith - O(1)

// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Trie {

//Creating class for trienode consisting of isEnd and children
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        //Constructor for trienode with children and isEnd initialization
        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }

//Declaring root and initialize it in the constructor
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    //To insert a word, iterate over the characters of the word while checking if it exists in the trie or not. If it does not exixt, iniatilze and insert it in trie. In the end mark last node's isEnd to true
    public void insert(String word) {
        TrieNode curr = this.root;
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    //Iterate over the word and if you find null in the trie, return false. In the end return the value of isEnd
    public boolean search(String word) {
        TrieNode curr = this.root;
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }
    ////Iterate over the prefix and if you find null in the trie, return false. In the end return true if we find till the end of the prefix
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(int i = 0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
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