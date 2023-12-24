// Implement Trie (Prefix Tree)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Trie {

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }
    
    // Time Complexity : O(m), where m is the key length
    // Space Complexity : O(m), where m is the key length
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
    
    // Time Complexity : O(m), where m is the key length
    // Space Complexity : O(1)
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }
    
    // Time Complexity : O(m), where m is the key length
    // Space Complexity : O(1)
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
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