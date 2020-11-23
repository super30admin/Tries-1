/**
 * 
 * Time Complexity : O(1) to search.
 * Space Complexity : 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * 
 Tries are DS to store strings
 They have same search complexity as hashmap but it is an optimal DS since it takes lesser space than a hashmap.
 Whenever a question asks to search entire word, prefix or suffix, always go with Trie first.
 In a trie, the root node contains all 26 chars(if only lowercase allowed..it would be 52 if uppercase are also allowed)
 now each child further has its own 26 chars' children.
 In order to know when the string end, at each trieNode we also store a boolean isEnd.
 To know the index of the current character we do [character - 'a']
 
 */

class Trie {

    class TrieNode{
        
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        
        root = new TrieNode();
        
        
    }
    
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            
            char c = word.charAt(i);
            if(curr.children[c - 'a'] != null) {
                
                curr = curr.children[c - 'a'];
            }
            else return false;
            
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] != null) {
                
                curr = curr.children[c - 'a'];
            }
            else return false;
            
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