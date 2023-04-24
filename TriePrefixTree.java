//Leetcode - 208
//Time Complexity - O(L) where L is length of the word, for all operations
//Space Complexity - O(nL) where L is avg.length
public class TriePrefixTree {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    private TrieNode root;
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i< word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public TriePrefixTree() {
        this.root = new TrieNode();
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i< word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0; i< prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}
