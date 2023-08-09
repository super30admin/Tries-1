// Time Complexity : O(L), where L is the length of the word
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : np


// Your code here along with comments explaining your approach
/**
 * 1. Create a TrieNode class with children array and isEnd boolean. 
 * 2. Create a Trie class with insert, search and startsWith methods.
 * 3. In insert method, iterate over the word and check if the character is present in the children array. 
 * If not, create a new TrieNode and add it to the children array.
 * 4. In search method, iterate over the word and check if the character is present in the children array.
 * If not, return false. If yes, return true.
 */


class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
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