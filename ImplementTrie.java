// LC - 208

class Trie {
    // creating a class TrieNode
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }
    // creating a root to access the initial trienode
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        // Initializing root
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
	// TC - O(n) -> number of characters in word
	// SC - O(1)
    // For every word, convert it to a charArray and check if character is null, if yes, we create a new TrieNode and curr will point there, at end we add true 
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
	// TC - O(n) -> number of characters in word
	// SC - O(1)
    // At each character in string, we check in our root if the character is null, if yes there is no word with that character, return false; else after done with iterating over word, check isWord where curr is pointing
    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
	// TC - O(n) -> number of characters in word
	// SC - O(1)
     // At each character in string, we check in our root if the character is null, if yes there is no word with that character, return false; else return false
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()){
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch-'a'];
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