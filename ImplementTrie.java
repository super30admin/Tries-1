/*
Problem: https://leetcode.com/problems/implement-trie-prefix-tree/

When you have strings, we could use tries or hashmap / hashset.
But hashmap / hashset uses more space than trie. Additionally, searching for prefixes is expensive

To count number of words that start with that prefix, we can keep a count of every character in the TrieNode. The count of the last character in the word will give number of words
with that prefix.
*/
class TrieNode {
    TrieNode children[];
    boolean isWord;
    
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

class Trie {

    TrieNode root = null;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        
        for (int i = 0;i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if (cur.children[index] == null)
                return false;
            cur = cur.children[index];
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

