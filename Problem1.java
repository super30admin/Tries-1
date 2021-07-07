//Implement Trie (Prefix Tree)

class Trie {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    //time o(n), n - length of the word
    //space o(1), as array with const size 26
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }
    
    //time o(n), n - length of the word
    //space o(1)
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null)
                return false;
            curr = curr.children[ch-'a'];
        }
       return curr.isEnd; 
    }
    
    //time o(n), n - length of the word
    //space o(1)
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++) {
            char ch = prefix.charAt(i);
            if(curr.children[ch-'a'] == null)
                return false;
            curr = curr.children[ch-'a'];
        }
        return true;
    }
}