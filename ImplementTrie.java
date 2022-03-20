// Time Complexity : O(m) for insertion, search and preFixMatch - m is the size of the word
// Space Complexity : O(n * m * Total_Char_Size) n - no of keys, m - word size, ALphabets_Size = 26. If ascii also included then 255 
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/658636680/) 
// Any problem you faced while coding this : No
// My Notes : Tradeoff is the extra space. If length or large data then no so efficient.
class TrieNode{
    final int ALPH_SIZE = 26;
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        this.children = new TrieNode[ALPH_SIZE];
        this.isEnd = false;
    }
}

class Trie {
    TrieNode trieRoot = null;
    
    public Trie() {
        trieRoot = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = trieRoot;
        for(int i = 0; i<word.length();i++){
            char c = word.charAt(i);
            int position = c -'a';
            if(node.children[position]==null){
                node.children[position] = new TrieNode();
            }
            node = node.children[position];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = trieRoot;
        for(int i = 0; i<word.length();i++){
            char c = word.charAt(i);
            int position = c -'a';
            if(node.children[position]==null){
                return false;
            }
            node = node.children[position];
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = trieRoot;
        for(int i = 0; i<prefix.length();i++){
            char c = prefix.charAt(i);
            int position = c -'a';
            if(node.children[position]==null){
                return false;
            }
            node = node.children[position];
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