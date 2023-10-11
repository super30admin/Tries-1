class Trie {

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26]; //26 because word prefix contains only lowercase
        }
    }
    TrieNode root;

    public Trie() {
        root = new TrieNode();
        
    }
    
    //TC - O(L) where L is length of the string  SC - O(L) - where L is length of the string
    public void insert(String word) {
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null){
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a']; //move current to next char
        }

        current.isEnd = true; //set current is end true because this will help in search to find end of word in tree
        
    }
    
    //TC - O(L) where L is length of the string  SC - O(1)
    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null){
                return false;
            }
            current = current.children[c - 'a'];
        }
        return current.isEnd;
    }
    
    //TC - O(L) where L is length of the prefix  SC - O(1)
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(current.children[c - 'a'] == null){
                return false;
            }
            current = current.children[c - 'a'];
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