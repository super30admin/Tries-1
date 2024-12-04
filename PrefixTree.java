// Time Complexity :insert :O(l)
//                  search :O(l)
//                  startsWith: O(l)
// Space Complexity :insert :O(n*n)
//                  search :O(1)
//                  startsWith: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class PrefixTree {
    TrieNode root;
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c-'a']==null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr= root;
        for(char c: prefix.toCharArray()){
            if(curr.children[c-'a']==null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true;
    }
}
