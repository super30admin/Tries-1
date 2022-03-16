// Time Complexity : O(k) where k is length of word
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * For each char, we will check if TrieNode is initialized or not.
 * For insert, we will keep on initializing TrieNode for each char if not present and for last char we mark isPresent as true
 * For search, we check if for each char TrieNode is initialized and for last char isPresent is marked as true
 * For prefix search, we check if for each char, TrieNode in initialized
*/


class Trie {
    
    class TrieNode{
        TrieNode[] child;
        boolean isPresent;
        
        public TrieNode(){
            child = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();    
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.length();i++){
            char ch = word.charAt(i);
            if(curr.child[ch - 'a'] == null){
                curr.child[ch - 'a'] = new TrieNode();
            }
            curr = curr.child[ch - 'a'];
        }
        
        curr.isPresent = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.length();i++){
            char ch = word.charAt(i);
            if(curr.child[ch - 'a'] == null)return false;
            curr = curr.child[ch - 'a'];
        }
        
        return curr.isPresent;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        for(int i = 0; i < prefix.length();i++){
            char ch = prefix.charAt(i);
            if(curr.child[ch - 'a'] == null)return false;
            curr = curr.child[ch - 'a'];
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