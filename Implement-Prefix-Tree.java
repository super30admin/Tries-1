## Problem1 
Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)

//Trie comes from word Retrieve. It is a tree like structure
//It is used in Spellcheckwer, auto completion

class Trie {
    //Node structure
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            children=new TrieNode[26];
            isEnd=false;
        }
    }
    //root node root will have a children array and every node of array will have the seperate isEnd variable
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    //in this what we are doing is we are checking 
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;

        
    }
    //To search we will go throught the end of the word at each step we will check if it is null or not if not then we will check at the end is curr.isend if it is true the n it exists else not
    public boolean search(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                return false;
            }
            curr=curr.children[c-'a'];
        }
        return curr.isEnd;
    }
    //In  this the difference only is regardless of if isEnd is true or false still we will return true
    public boolean startsWith(String prefix) {
        TrieNode curr= root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if(curr.children[c-'a']==null){
                return false;
            }
            curr=curr.children[c-'a'];
        }
        return true;
    }
}
