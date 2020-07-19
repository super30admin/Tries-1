// Time Complexity : O(n) n is string length
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Trie {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
        
    }
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            if(node.children[word.charAt(i)-'a']==null){
                node.children[word.charAt(i)-'a'] = new TrieNode();
            }
                    
                node = node.children[word.charAt(i)-'a'];
        }
        node.isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            if(node.children[word.charAt(i) - 'a']==null) return false;
            node = node.children[word.charAt(i) - 'a'];
        }
        return node.isEnd;  
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            if(node.children[word.charAt(i) - 'a']==null) return false;
            node = node.children[word.charAt(i) - 'a'];
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