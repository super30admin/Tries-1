// Time Complexity : O(L) 
// Space Complexity : O(N*L)

class Trie {
    TrieNode root;

    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode(){
            this.children = new HashMap<>();
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children.get(c) == null) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.childern.get(c) == null) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()){
            if(curr.childern.get(c) == null) {
                return false;
            }
            curr = curr.children.get(c);
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