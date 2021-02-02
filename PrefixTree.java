// /**
//  * Your Trie object will be instantiated and called as such:
//  * Trie obj = new Trie();
//  * obj.insert(word);
//  * boolean param_2 = obj.search(word);
//  * boolean param_3 = obj.startsWith(prefix);
//  */

// Did it run succesfully on Leetcode? : Yes
class Trie { 
    TrieNode root;
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        TrieNode()
        {
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    public Trie()
    {
        root = new TrieNode();
    }
    /** Inserts a word into the trie. */
    // TC: O(mn) -> m: avg length of wprd, n : no.of words
    // SC: O(mn) -> m: avg length of wprd, n : no.of words
    public void insert(String word) {
        TrieNode cur = root;
        for ( int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null)
            {
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isEnd = true;
    }
     /** Returns if the word is in the trie. */
    // TC: O(m) - m: length of word
    // SC: O(1)
    public boolean search(String word) {
        TrieNode cur = root;
        for ( int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null)
                  return false;
             cur = cur.children[c-'a'];
        }
        return cur.isEnd; 
    }
     /** Returns if there is any word in the trie that starts with the given prefix. */
    // TC: O(m) - length of prefix
    // SC: O(1)
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for ( int i = 0; i < prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if (cur.children[c-'a'] == null)
                  return false;
            cur = cur.children[c-'a'];
        }
        return true;
    }
}


