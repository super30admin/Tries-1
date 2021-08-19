/**Time complexity: 
insert - O(w), where w is the length of the word
search - O(w), where w is the length of the word
startsWith - O(w), where w is the length of the prefix string.
Space complexity: 
insert - O(w), where w is the max possible length of word.
search - O(1)
startsWith - O(1)
**/
class TrieNode {
    private boolean isEnd;
    private TrieNode links[];
    
    TrieNode() {
        links = new TrieNode[26];
    } 
    
    public boolean contains(char c) {
        return links[c-'a'] != null;
    }
    
    public void put(char c) {
        links[c-'a'] = new TrieNode(); 
    }
    
    public TrieNode get(char c) {
        return links[c-'a']; 
    }
    
    public void setEnd() {
        isEnd = true;
    }
    
    public boolean isEnd() {
        return this.isEnd; 
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
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            if(!node.contains(c)) {
                node.put(c); 
            } 
            node = node.get(c); 
        }
        node.setEnd(); 
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            if(!node.contains(c)) {
                return false; 
            } 
            node = node.get(c); 
        }
        return node.isEnd(); 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c: prefix.toCharArray()) {
            if(!node.contains(c)) {
                return false; 
            } 
            node = node.get(c); 
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