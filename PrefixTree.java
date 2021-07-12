/* TC , SC  - o(L) - sum of lengths of words,  
 * */

class TrieNode{
    boolean isEnd;
    TrieNode[] children;
    public TrieNode(){
        this.children = new TrieNode[26];
        this.isEnd = false; // it is by default
    }
}
class Trie {
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0 ; i < word.length(); i++){
            char ch = word.charAt(i);
            if (curr.children[ch-'a'] == null){
                // insert a trie node here at this location
                TrieNode node = new TrieNode();
                curr.children[ch-'a'] = node;
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        // check if the series of nodes with the character exists
        TrieNode curr = root; 
        for (int i = 0 ; i < word.length(); i++){
            char ch  = word.charAt(i);
            if (curr.children[ch-'a'] == null) return false;
            curr = curr.children[ch-'a'];
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       TrieNode curr = root; 
        for (int i = 0 ; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if (curr.children[ch-'a'] == null) return false;
            curr = curr.children[ch-'a'];
        }
        return true;
    }
}

