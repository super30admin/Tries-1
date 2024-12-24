// space complexity = O(l*26). which is O(l)
// the search functionality for the hashset is O(N)<- the no. of words .
// the space complexity for the hashset is O(N). a lot bigger than the Trie.
// Trie is space efficient than Hashset and search is better than hashset.

class Trie {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }        
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
        
    }
    
    public void insert(String word) { // O(l)
        TrieNode current = root;
        for(int i=0;i< word.length();i++) {
            int idx = word.charAt(i)- 'a';
            if(current.children[idx] == null) {
                current.children[idx] = new TrieNode();
            }
            current = current.children[idx];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) { // O(l)
        TrieNode current = root;
        for(int i=0;i< word.length();i++) {
            int idx = word.charAt(i) - 'a';
            if(current.children[idx] == null) {
                return  false;
            }
            current = current.children[idx];
        }
        return current.isEnd;
    }
    
    public boolean startsWith(String prefix) { // O(l)
        TrieNode current = root;
        for(int i=0;i< prefix.length();i++) {
            int idx = prefix.charAt(i) - 'a';
            if(current.children[idx] == null) {
                return  false;
            }
            current = current.children[idx];
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