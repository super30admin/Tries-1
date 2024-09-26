
//Problem1 
//Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)
// time - O(n) space -  O(n)
class Trie {
    
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
         root = new TrieNode();
    }
 
    // Insert into a trie
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            
            if(curr.children[c - 'a'] == null){
               return false;
            }
            curr = curr.children[c - 'a'];
        }
        
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()){
            
            if(curr.children[c - 'a'] == null){
               return false;
            }
            curr = curr.children[c - 'a'];
        }
        
        return true;
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isEnd;

    /** Initialize your data structure here. */
    public TrieNode() {
         children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */