// Time Complexity : O(sum of lengths of words)
// Space Complexity : O(length of words)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I added everything to a trie, and for each word I checked if it can be made from other words - basically all characters within that TrieNode till that word ends should be an end point.

class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String word : words) trie.insert(word);
        String longest = "";
        for(String word : words){
            if(word.length()>longest.length() || (word.length()==longest.length() && word.compareTo(longest)<0)){
                if(helper(word, trie)) longest = word;
            }
        }
        return longest;
    }

    public boolean helper(String word, Trie trie){
        Trie.TrieNode root = trie.root;
        for(int i = 0; i<word.length()-1;i++){
            root = root.children[word.charAt(i)-'a'];
            if(!root.inEnd) return false;
        }
        return true;
    }
}

class Trie {
    class TrieNode{
        boolean inEnd;
        TrieNode[] children;

        public TrieNode(){
            inEnd = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0;i<word.length(); i++){
            int child = word.charAt(i)-'a';
            if(curr.children[child]==null){
                curr.children[child]= new TrieNode();
            }
            curr = curr.children[child];
        }
        curr.inEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0;i<word.length(); i++){
            int child = word.charAt(i)-'a';
            if(curr.children[child]==null){
                return false;
            }
            curr = curr.children[child];
        }
        return curr.inEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0;i<prefix.length(); i++){
            int child = prefix.charAt(i)-'a';
            if(curr.children[child]==null){
                return false;
            }
            curr = curr.children[child];
        }
        return true;
    }
}