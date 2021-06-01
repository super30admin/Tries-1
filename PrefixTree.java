// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


class Trie {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
       root = new TrieNode(); 
    }
    
    //Time Complexity : O(n) where n is the length of the word being inserted into the trie
    //Space Complexity: O(26 power n) since we are creating a new array for every case and considering we are having 26 alphabets  
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    //Time Complexity : O(n) where n is the length of the word being inserted into the trie
    //Space Complexity: O(1) since we are not using any extra space for the operations inside this method
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }
    
    //Time Complexity : O(n) where n is the length of the word being inserted into the trie
    //Space Complexity: O(1) since we are not using any extra space for the operations inside this method
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return true;

    }
}
