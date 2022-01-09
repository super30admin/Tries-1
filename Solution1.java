// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach
class Trie {
    TrieNode root;
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode(){
            children=new TrieNode[26];
            isEnd=false;
        }
    }
    public Trie() {
        root= new TrieNode();
    }
    
// Time Complexity O(l) for inserting  1 word with length l
// Space Complexity :O(l*26) for each character we have an array of 26 length and one bool variable
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char c= word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']= new TrieNode();
            }
            curr= curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    
// Time Complexity O(l) for searching  1 word with length l
// Space Complexity :O(l*26) for each character we have an array of 26 length and one bool variable
    public boolean search(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char c= word.charAt(i);
            if(curr.children[c-'a']==null){
                return false;
            }
            curr= curr.children[c-'a'];
        }
        return curr.isEnd;
    }
    
// Time Complexity O(l) for searching  1 word with length l
// Space Complexity :O(l*26) for each character we have an array of 26 length and one bool variable
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++){
            char c= prefix.charAt(i);
            if(curr.children[c-'a']==null){
                return false;
            }
            curr= curr.children[c-'a'];
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