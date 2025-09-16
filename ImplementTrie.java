// Time Complexity : O(N*l) for insert, O(l) for search, O(prefix length) for startsWith
// Space Complexity : O(1) - constant space for children array of size 26
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
// Each TrieNode contains an array of 26 children (lowercase for this problem) and a boolean to mark the end of a word
// We use the root to access the start and check if the ascii value of character is there or not. Its respective index is char - 'a'
// We search the words and prefix by moving down the trie and checking for not null values

class Trie {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();    
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
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