// TC : O(n) word length
// SC : O(n) word length
// TrieNode implementation

class Trie {
    
    class TrieNode {
        TrieNode[] child;
        boolean isEnd;
        char ch;
        TrieNode() {
            child = new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(temp.child[c - 'a'] == null) 
                temp.child[c - 'a'] = new TrieNode();
            temp = temp.child[c - 'a'];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        
        TrieNode temp = root;
        
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(temp.child[c - 'a'] != null)
                temp = temp.child[c - 'a'];
            else
                return false;
        }
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(temp.child[c - 'a'] == null)
                return false;
            temp = temp.child[c - 'a'];
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
