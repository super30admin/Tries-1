class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[26];
    }
 }
 public class Trie{
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode cursor = root;
        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (cursor.children[c - 'a'] == null) cursor.children[c - 'a'] = new TrieNode();
            cursor = cursor.children[c - 'a'];
            }
        cursor.isEndOfWord = true;
    }
    public boolean search(String word) {
        TrieNode cursor = root;
        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (cursor.children[c - 'a'] == null) return false;
            cursor = cursor.children[c - 'a'];
        }
        return cursor.isEndOfWord;
    }
    public boolean startsWith(String prefix) {
        TrieNode cursor = root;
       char c;
        for (int i = 0; i < prefix.length(); i++) {
            c = prefix.charAt(i);
            if (cursor.children[c - 'a'] == null) return false;
            cursor = cursor.children[c - 'a'];
        }
       return true;
    }
 }