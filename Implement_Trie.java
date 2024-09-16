// Time Complexity :
// Space Complexity : 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Trie {
class TrieNode{
    private TrieNode[] children;
    private boolean isEnd;
    
    public TrieNode(){
        children = new TrieNode[26];
    }
    
    public boolean containsKey(char ch){
        return children[ch-'a']!=null;
    }
    
    public TrieNode get(char ch){
        return children[ch-'a'];
    }
    
    public void put(char ch, TrieNode node){
        children[ch-'a']=node;
    }
}
    private final TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr=root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(!curr.containsKey(c)){
                curr.put(c,new TrieNode());
            }
            curr=curr.get(c);
        }
        curr.isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr=root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(!curr.containsKey(c)){
                return false;
            }
            curr=curr.get(c);
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(int i = 0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(!curr.containsKey(c)){
                return false;
            }
            curr=curr.get(c);
        }
        return true;
    }
}
