class Trie {
    class TrieNode{
        TrieNode [] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
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
            char a = word.charAt(i);
            if(curr.children[a - 'a'] == null){
                curr.children[a - 'a'] = new TrieNode();
            } 
            curr = curr.children[a - 'a'];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char a = word.charAt(i);
            if(curr.children[a - 'a'] == null) return false;
            curr = curr.children[a - 'a'];
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char a = prefix.charAt(i);
            if(curr.children[a - 'a'] == null) return false;
            curr = curr.children[a - 'a'];
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
