class Trie {

// Time Complexity : O(L) | Length of a String
// Space Complexity : O(LxN) | L : AVG length of a string and N : total number of strings
// Leetcode : Yes

    class TrieNode {
        boolean isEnd;
        TrieNode[] childrens;

        public TrieNode(){
            isEnd = false;
            childrens = new TrieNode[26];
        }

    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
         root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if(curr.childrens[c - 'a'] == null){
               curr.childrens[c - 'a'] = new TrieNode();
            }

            curr = curr.childrens[c - 'a'];
        }
        curr.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;

        for(int i = 0; i< word.length(); i++){
            char c = word.charAt(i);

            if(curr.childrens[ c - 'a'] == null){
                return false;
            }
            curr = curr.childrens[c - 'a'];
        }

        return curr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);

            if(curr.childrens[c - 'a'] == null){
                return false;
            }

            curr = curr.childrens[c - 'a'];
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
