// Time Complexity : 
//Insert : O(L)
//Search: O(L)
//Prefix: O(L)
// Space Complexity : 
//Insert : O(L)
//Search: O(1)
//Prefix: O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Trie data structure is used in solving string related problems, mainly to spell check, check prefix
 * It maintains a boolean variable and TrieNode array of size 26
 * Insert: Create a current TrieNode and point to the root and Tarverse through the length of the word and 
 * insert trie node in the index of the character [c-'a'] and mark the boolean variable as True after the completion of the word
 * Search : Create a current TrieNode and point to the root and Tarverse through the length of the word and 
 * point curr to the character [c-'a'] and return true if the word is found
 * Prefix : Create a current TrieNode and point to the root and Tarverse through the length of the prefix and 
 * point curr to the TrieNode at character [c-'a'] and return true if the prefix traversal is completed
 */
class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i< word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c -'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i< word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEnd ;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i< prefix.length();i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true ;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
