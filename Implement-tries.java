class Trie {
    // Time complexity is O(m*l) + O(n*k) 
    // O(m*l) is for creating trie
    // O(n*k) is for search where k is the average length
    // Space complexity is O(n*L) where n is the number of words and L is the length
    // Let me know if space complexity is correct
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    // Keep root in global scope
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        // Take a pointer
        TrieNode curr = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c- 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
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