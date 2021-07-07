/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class Trie {
    private TrieNode root;

    public class TrieNode{
        TrieNode[] next;
        boolean isEnd;
        public TrieNode(){
            this.next =new TrieNode[27];
            this.isEnd=false;
        }
    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }


    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.next[ch - 'a'] == null){
                curr.next[ch - 'a'] = new TrieNode();
            }
            curr=curr.next[ch - 'a'];
        }
        curr.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.next[ch - 'a'] == null){
                return false;
            }
            curr=curr.next[ch - 'a'];
        }
        return curr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(curr.next[ch - 'a'] == null){
                return false;
            }
            curr=curr.next[ch - 'a'];
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