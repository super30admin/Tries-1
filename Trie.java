package org.example;

// Time Complexity : O(L) ->L is the length of the word
// Space Complexity : O(26*L)->O(L) -> space of the TrieNode
// Did this code successfully run on Leetcode : Yes

class Trie {

    TrieNode root;

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode()
        {
            this.children = new TrieNode[26];
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {   //O(L)

        TrieNode curr = root;
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr =curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) { //O(L)
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                return false;
            }
            curr =curr.children[c-'a'];
        }
        return curr.isEnd;

    }

    public boolean startsWith(String prefix) { //O(P)
        TrieNode curr = root;
        for(int i=0; i<prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if(curr.children[c-'a']==null)
            {
                return false;
            }
            curr =curr.children[c-'a'];
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