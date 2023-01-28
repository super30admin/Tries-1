// Time Complexity : insert(), search(), startsWith() runs in O(L) where L=length of input string
// Space Complexity : insert(), search(), startsWith() runs in constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Each node in Trie is represented as TrieNode
// TrieNode has an array of TrieNodes called children(here size is 26 as we are only using lower case alphabet)
// It also has boolean isEnd to keep track of whether we reached the end of the word

class Trie {
    private class TrieNode {
        private TrieNode[] children;
        private boolean isEnd;
        private TrieNode(){
            children = new TrieNode[26];
        }
    }
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null) return false;
            curr = curr.children[ch-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(curr.children[ch-'a']==null) return false;
            curr = curr.children[ch-'a'];
        }
        return true;
    }
}