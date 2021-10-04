package Tries1;
// Time Complexity: insert, search and prefix O(L) - length of the word
// Space Complexity : O(L) for each function
// Did this code successfully run on Leetcode : yes



class TrieNode{
    boolean isEnd;
    TrieNode[] children;
    TrieNode(){
        children = new TrieNode[26];
    }
}

public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);

            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true;
    }
}