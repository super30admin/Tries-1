class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode start = this.root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            start.map.putIfAbsent(c, new TrieNode());
            start = start.map.get(c);
        }
        start.isEnd = true;
    }
    
    public boolean search(String word) {

        TrieNode start = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (start.map.containsKey(c)) {
                start = start.map.get(c);
            } else {
                return false;
            }
            
        }
        return start.isEnd;
    }
    
    public boolean startsWith(String prefix) {

        TrieNode start = root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (start.map.containsKey(c)) {
                start = start.map.get(c);
            } else {
                return false;
            }
            
        }
        return true;
        
    }
}

class TrieNode {
    public Map<Character, TrieNode> map;
    public boolean isEnd;

    public TrieNode () {
        this.map = new HashMap<>();
        this.isEnd = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */