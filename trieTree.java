// Time Complexity :O(L)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

public class trieTree {
    class TrieNode{
        TrieNode [] children;
        boolean isEnd;
        
        public TrieNode(){
            this.children=new TrieNode[26];
        }
    }
    
    /** Initialize your data structure here. */
    TrieNode root;
    
    public void Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
         TrieNode curr=root;
        
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] ==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr=root;
        
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] ==null)
                return false;
            curr=curr.children[c-'a'];
    }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode curr=root;
        
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] ==null)
                  return false;
            curr=curr.children[c-'a'];
            
            }
        
        return true;
    }
}
