// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class ImplementPrefixTrie {
    public class TrieNode{
        public final int ALPHABET_SIZE = 26;
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean endOfWord = false;
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public ImplementPrefixTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int wordLength = word.length();
        int level, index;
        TrieNode topRoot = root;

        for(level = 0; level<wordLength ; level++){
            index = word.charAt(level) - 'a';
            if(topRoot.children[index] == null){
                topRoot.children[index] = new TrieNode();
            }
            topRoot = topRoot.children[index];
        }
        topRoot.endOfWord = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode topRoot = root;
        int wordLength = word.length();
        int level, index;

        for(level = 0; level<wordLength; level++){
            index = word.charAt(level) - 'a';
            if(topRoot.children[index] == null){
                return false;
            }
            topRoot = topRoot.children[index];
        }
        if(topRoot.endOfWord){
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode topRoot = root;
        int wordLength = prefix.length();
        int level, index;

        for(level = 0; level<wordLength; level++){
            index = prefix.charAt(level) - 'a';
            if(topRoot.children[index] == null){
                return false;
            }
            topRoot = topRoot.children[index];
        }
        return true;
    }
}
