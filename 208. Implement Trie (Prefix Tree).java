// Time Complexity : O(l) length of the word/prefix
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding space complexity


// Your code here along with comments explaining your approach:
// each trieNode has 26 children as we have only lower case letters and a boolen variable to determine the end of the word
// while inserting we take a curr pointer at root and this curr pointer will be moving down the trie.
// we iterate through the length of the string and check in the children array if that particular index ( char - 'a') is null if so we insert a new trie node 
// other wise we move the curr pointer to that location and at the last index make the boolean variable true. 
// for search if the index in the children array is null we return false;

class Trie {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i =0; i< word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i =0; i< word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null) return false;
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i =0; i< prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if(curr.children[c-'a']==null) return false;
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