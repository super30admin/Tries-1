class Trie {
    class TrieNode{
        boolean IsEnd;
        TrieNode[] Children;
        
        public TrieNode(){
            Children = new TrieNode[26];
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
            char c = word.charAt(i);
            if(curr.Children[c - 'a'] == null){
                curr.Children[c - 'a'] = new TrieNode();
            }
            curr = curr.Children[c - 'a'];
        }
        curr.IsEnd = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.Children[c - 'a'] == null){
                return false;
            }
            curr = curr.Children[c - 'a'];
        }
        return curr.IsEnd ;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.Children[c - 'a'] == null){
                return false;
            }
            curr = curr.Children[c - 'a'];
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
