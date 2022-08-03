class Trie {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    // TC is O(l) where l is the length of word
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i< word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            } 
            
            curr = curr.children[c-'a'];
            if(i == word.length()-1){
                    curr.isEnd = true;
                }
        }
    }
    
    public TrieNode getChildTrie(String word){
        TrieNode curr = root;
        for(int i=0; i< word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) return null;
            curr = curr.children[c-'a'];
        }
        return curr;
    }
    
    // TC is O(l) where l is the length of word
    public boolean search(String word) {
        TrieNode node = getChildTrie(word);
        if(node == null) return false;
        else if(node.isEnd) return true;
        return false;
    }
    // TC is O(l) where l is the length of word
    public boolean startsWith(String prefix) {
        TrieNode node = getChildTrie(prefix);
        if(node == null) return false;
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