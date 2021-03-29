class Trie {
    
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    //O(n) TC
    //O(n) SC critique pointers since not inserted actually
    public void insert(String word) {
        TrieNode curr = root;
        
        for(char ch : word.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            
            curr=curr.children[ch - 'a'];
        }
        
        curr.isWord = true; //word is formed
    }
    
    /** Returns if the word is in the trie. */
    
    //O(n)
    //O(1)
    public boolean search(String word) {
        TrieNode curr = root;
        
        for(char ch : word.toCharArray()){
            
            //word or char doesnot exist
            if(curr.children[ch - 'a'] == null){
                return false;
            }
            
            curr = curr.children[ch - 'a'];
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    //O(n) TC
    //O(1) SC
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        for(char ch : prefix.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                return false;
            }
            
            curr=curr.children[ch - 'a'];
        }
        
        return true; //word is found return
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */