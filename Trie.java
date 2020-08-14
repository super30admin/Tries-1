class Trie {

    class TrieNode {
        boolean isEndofWord;
        TrieNode children[];
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /**
     * Time complexity: O(N) where N is the word length
     * Space complecity: O(N) where N is the word length
     */
    public void insert(String word) {
        
        TrieNode curr = root;
        
        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        
        curr.isEndofWord = true;
        
    }
    /**
     * Time complexity: O(N) where N is the word length
     * Space complecity: O(1)
     */
    public boolean search(String word) {
        TrieNode curr = root;
        
        if(curr == null)
            return false;
        
        for(char c : word.toCharArray()) {
            if(curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEndofWord;
    }
    
    /**
     * Time complexity: O(N) where N is the prefix length
     * Space complecity: O(1)
     */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        if(curr == null)
            return false;
        
        for(char c : prefix.toCharArray()) {
            if(curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true;
    }
}
