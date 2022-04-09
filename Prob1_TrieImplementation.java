// Time Complexity : O(L) //For insert, search and startsWith method

// n - words in disctionary, k = Avg. Length of words in disctionary

// Space Complexity : O(N*K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



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
        TrieNode curr = root; // Taken root as current to traverse ther Trie
        for(int c = 0; c< word.length(); c++){
            char ch = word.charAt(c);
            if(curr.children[ch - 'a'] == null){ //Checking if curr's children having character ch or not
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true; // Making isEnd to true to check word ended here or not for future
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int c = 0; c< word.length(); c++){
            char ch = word.charAt(c);
            if(curr.children[ch - 'a'] == null){ 
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int c = 0; c< prefix.length(); c++){
            char ch = prefix.charAt(c);
            if(curr.children[ch - 'a'] == null){ 
                return false;
            }
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