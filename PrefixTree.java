// Time Complexity : O(N*k) -- where N is number of words and k is avg length of words
// Space Complexity : O(N*k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Form a Trie
*/
public class PrefixTree {
    class TrieNode{
        TrieNode[] children;
        //by Default== false
        boolean isEnd;
        TrieNode(){
            children= new TrieNode[26];
        }
    }

    TrieNode root;
    public Trie() {
        root= new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a']= new TrieNode();
            }
            curr=curr.children[ch-'a'];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            if(curr.children[ch-'a']==null) return false;
            curr=curr.children[ch-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char ch:prefix.toCharArray()){
            if(curr.children[ch-'a']==null) return false;
            curr=curr.children[ch-'a'];
        }
        return true;
    }
}