
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No issues


// Your code here along with comments explaining your approach

class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    // Time Complexity : O(l)
    // Space Complexity : O(l)
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a']; // move curr pointer to next child
        }

        curr.isEnd = true;
    }
    // Time Complexity : O(l)
    // Space Complexity : O(1)
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){ // we don't have next child, word is not present
                return false;
            }
            curr = curr.children[c - 'a']; // move curr pointer to next child
        }

        return curr.isEnd;
    }
    // Time Complexity : O(l)
    // Space Complexity : O(1)
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0 ; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null){ // we don't have next child, prefix is not present
                return false;
            }
            curr = curr.children[c - 'a']; // move curr pointer to next child
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