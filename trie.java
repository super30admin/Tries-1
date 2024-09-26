search complexity is o(n), o(1) for each character
the root and its childfen and its nested children are stored in a hashmap and searching in a hashmap for a single character is o(1)
space : o(1)
class TrieNode {
    
    public char value;
    public TrieNode[] node = new TrieNode[26];
    public boolean isEnd;
    public TrieNode() {}
    
    
}

class Trie {
    
    TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public Trie() {
        
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        
        TrieNode cur = root;
        
        for(int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            if(cur.node[letter - 'a'] == null){
                cur.node[letter - 'a'] = new TrieNode();
            }
            
            cur = cur.node[letter - 'a'];
        }
        
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode cur = root;
        
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.node[c - 'a'] == null) return false;
            cur = cur.node[c - 'a'];
        }
        
        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode cur = root;
        
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.node[c - 'a'] == null) return false;
            cur = cur.node[c - 'a'];
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