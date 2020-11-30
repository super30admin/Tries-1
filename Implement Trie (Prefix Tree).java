/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/

class TrieNode {
    
    public char value;
    public TrieNode[] character = new TrieNode[26];
    public boolean isWord;
    
    public TrieNode() {}
    
    public TrieNode(char c){
        
        // TrieNode node = new TrieNode();
        // node.value = c;

        value = c;
    }
}

class Trie {
    
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        
        root = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        
        TrieNode cur = root;
        
        for(int i = 0; i < word.length(); i++){
            
            char letter = word.charAt(i);
            
            if(cur.character[letter - 'a'] == null){
                
                cur.character[letter - 'a'] = new TrieNode(letter);
            }
            
            cur = cur.character[letter - 'a'];
        }
        
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode cur = root;
        
        for(int i = 0; i < word.length(); i++){
            
            char c = word.charAt(i);
            
            if(cur.character[c - 'a'] == null) return false;
            
            cur = cur.character[c - 'a'];
        }
        
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode cur = root;
        
        for(int i = 0; i < prefix.length(); i++){
            
            char c = prefix.charAt(i);
            
            if(cur.character[c - 'a'] == null) return false;
            
            cur = cur.character[c - 'a'];
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