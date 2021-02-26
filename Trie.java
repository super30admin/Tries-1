// Time Complexity : O(n) n is no of keys
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class TrieNode {
    
    boolean isWord;
    HashMap<Character, TrieNode> childrens;
    
    public TrieNode() {
        childrens = new HashMap(26);
    }
    
}

class Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            
            if(!curr.childrens.containsKey(c)) {
                curr.childrens.put(c, new TrieNode());
            }
            curr = curr.childrens.get(c);
            
        }
        curr.isWord = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            
            if(!curr.childrens.containsKey(c)) {
                return false;
            }
            curr = curr.childrens.get(c);
            
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()) {
            
            if(!curr.childrens.containsKey(c)) {
                return false;
            }
            curr = curr.childrens.get(c);
            
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
