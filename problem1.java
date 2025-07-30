// Time Complexity : O(length of word or prefix)
// Space Complexity : O(length of word or prefix)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Aprroach : Used an array of TrieNode to store children of each node and boolean to represent if a word ends at that node.
// We can insert, search and check for prefix in O(length of word or prefix) time
// The TrieNode class is used to represent each node in the Trie, with an array of children and a boolean to indicate if a word ends at that node.

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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */