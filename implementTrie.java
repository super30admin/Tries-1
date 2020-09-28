    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/implement-trie-prefix-tree/
    Time Complexity for operators : o(n) .. n is word of length
    Extra Space Complexity for operators : o(n) n is number of characters
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. Trie
                    A) First create the trieNode class with 26 chracters of array and with isWord booelans flag.
                    B) For inser create trienode for each of the word from the input.
                    C) At the end of the word make the boolean flag  to true that means word exists till that point.
                    D) for search - we will start from the first charatcer of the word and traverse till the end of the word.
                    F) if in between null if found for specific character then return flase. we dont have that word.
                    G) At the end of search return curr.isword, we found the word then it will return true else false.
                    H) Check for the prefix in a same way a s that of search but return true at the end. 
    */  

class Trie {
    
    class TrieNode{
        TrieNode[] childrens;
        boolean isWord;
        
        public TrieNode(){
            childrens = new TrieNode[26];
            isWord = false;
        }
    }

    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();   
    }
    
    /** Inserts a word into the trie. */
    // RUNTIME O(n) .. n is word of length
    public void insert(String word) {
        TrieNode curr = root;
        
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            
            // current has that elemnt or not if it is null then we dont have any w ord start with insert word.
            if(curr.childrens[ch-'a'] == null){
                curr.childrens[ch-'a'] = new TrieNode();
            }
            
            curr = curr.childrens[ch-'a'];
        }
        
        // we are at the end of word now make isWord to true so that we can identify the word/
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    // RUNTIME O(n) .. n is word of length
    //space complexity will be O(n) whenre n is number of charaters.
    
    public boolean search(String word) {
        TrieNode curr = root;
        
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            
            // current has that elemnt or not if it is null then we dont have any w ord start with insert word.
            if(curr.childrens[ch-'a'] == null){
                return false;
            }
            
            curr = curr.childrens[ch-'a'];
        }
        
        // we are at the end of word now make isWord to true so that we can identify the word
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    // RUNTIME O(n) .. n is word of length
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            
            // current has that elemnt or not if it is null then we dont have any w ord start with insert word.
            if(curr.childrens[ch-'a'] == null){
                return false;
            }
            
            curr = curr.childrens[ch-'a'];
        }
        
        // we are at the end of word now make isWord to true so that we can identify the word
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