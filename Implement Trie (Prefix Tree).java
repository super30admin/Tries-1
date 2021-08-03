class TrieNode{

    boolean end;
    TrieNode[] children;

    public TrieNode()
    {
        children = new TrieNode[26];
    }
}

class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode curr = root;

        for(char c : word.toCharArray())
        {
            if(curr.children[c-'a'] == null) curr.children[c-'a'] = new TrieNode();

            curr = curr.children[c-'a'];
        }

        curr.end = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        TrieNode curr = root;

        for(char c : word.toCharArray())
        {
            if(curr.children[c-'a'] == null) return false;

            curr = curr.children[c-'a'];
        }

        return curr.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {

        TrieNode curr = root;

        for(char c : word.toCharArray())
        {
            if(curr.children[c-'a'] == null) return false;

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
