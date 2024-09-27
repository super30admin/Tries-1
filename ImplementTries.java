

class Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cursor = root;
        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cursor.children[ch -'a'] == null)
                cursor.children[ch -'a'] = new TrieNode();
            cursor = cursor.children[ch -'a'];
        }
        cursor.isEnd = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cursor = root;
        for(int i =0; i<word.length();i++){
            char ch = word.charAt(i);
            if(cursor.children[ch - 'a'] == null)
                return false;
            cursor = cursor.children[ch -'a'];
        }
        return cursor.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cursor = root;
        for(int i = 0; i< prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(cursor.children[ch -'a'] == null)
                return false;
            cursor = cursor.children[ch -'a'];
        }
        return true;
    }
}

/**
 * Your T1,rie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    
     TrieNode() {
        children = new TrieNode[26];
    }
}
