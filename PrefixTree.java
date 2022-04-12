/**
 * Time complexity for each operation is length of the word.
 * space complexity is proportional to max length of the words inserted so far.
 */
class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.nodes[ch-'a'] == null) {
                curr.nodes[ch-'a'] = new TrieNode();
            }
            curr = curr.nodes[ch-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.nodes[ch-'a'] == null) {
                return false;
            }
            curr = curr.nodes[ch-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()) {
            if(curr.nodes[ch-'a'] == null) {
                return false;
            }
            curr = curr.nodes[ch-'a'];
        }
        return true;        
    }
    
    class TrieNode{
        boolean isEnd;
        TrieNode[] nodes;
        public TrieNode() {
            isEnd = false;
            nodes = new TrieNode[26];
        }
    }
}