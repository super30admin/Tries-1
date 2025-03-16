class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    // TC: O(l) > l: length of string
    public void insert(String word) {
        if(word == null || word.length() == 0) return;
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    // TC: O(l) > l: length of string
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }
    // TC: O(p) > l: length of prefix
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0) return true;
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
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
