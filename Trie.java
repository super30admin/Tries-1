// Node that represents the each character of dictionary
class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[26];
        isEnd = false;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = this.root;
        // Iterate through each character
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            TrieNode node = curr.children[c-'a'];
            // check for character being available, if not create one node for this character
            if(node==null) {
                curr.children[c-'a'] = new TrieNode();
            }
            // iterate to next character node
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = this.root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            TrieNode node = curr.children[c-'a'];
            // check for character being available, if not return false
            if(node==null) {
                return false;
            }
            // iterate to next character node
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(int i=0;i<prefix.length();i++) {
            char c = prefix.charAt(i);
            TrieNode node = curr.children[c-'a'];
            // check for character being available, if not return false
            if(node==null) {
                return false;
            }
            // iterate to next character node
            curr = curr.children[c-'a'];
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
