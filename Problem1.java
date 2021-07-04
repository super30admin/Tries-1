

class Trie {

    class TrieNode {
        boolean isEnd;
        TrieNode [] children; //make an array
        public TrieNode() {
            children = new TrieNode[26]; // array of 26 characters
        }


    }
    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i); // curr // second iteration. //a
            if( curr.children[c - 'a'] == null) {
                // if it is empty insert
                curr.children[c - 'a']  = new TrieNode(); // ba
            }
            curr = curr.children[c - 'a']; // b
        }

        curr.isEnd = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if( curr.children[c - 'a'] == null) return false; // if the character's children is null which is not found
            curr = curr.children[c - 'a']; // if found continue
        }

        return curr.isEnd;


    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        // check with respect to prefix length
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if( curr.children[c - 'a'] == null) return false; // if the character's children is null which is not found
            curr = curr.children[c - 'a']; // if found continue
        }

        return true;

    }
}
