// Time Complexity : O(n) 
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approachclass 
class Trie {
    
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode(){
            children=new TrieNode[26];
            isWord=false;
        }
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode curr = root;
        for(int x=0;x<word.length();x++){
            char ch = word.charAt(x);
            
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a']=new TrieNode();
            }
            
            curr=curr.children[ch-'a'];
        }
        curr.isWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int x=0;x<word.length();x++){
            char ch = word.charAt(x);
            
            if(curr.children[ch-'a']==null){
                return false;
            }
            
            curr=curr.children[ch-'a'];
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int x=0;x<prefix.length();x++){
            char ch = prefix.charAt(x);
            
            if(curr.children[ch-'a']==null){
                return false;
            }
            
            curr=curr.children[ch-'a'];
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