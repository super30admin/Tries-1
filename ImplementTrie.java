class Trie {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            this.children =  new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null) return false;
            curr = curr.children[ch - 'a'];
        }
        if(curr.isEnd) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(curr.children[ch - 'a'] == null) return false;
            curr = curr.children[ch - 'a'];
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