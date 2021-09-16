using System;
using System.Collections.Generic;
using System.Text;

namespace Tries
{
    class Trie
    {
        class TrieNode
        {
            internal TrieNode[] children;
            internal bool isEnd;
            public TrieNode()
            {
                children = new TrieNode[26];
            }
        }

        //Initialize your data structure here
        public Trie()
        {
            root = new TrieNode();
        }
        TrieNode root;
        //TC for Insert, Search & Startswith: O(L)
        //SC: for insert O(nK) for search & startwith O(1)
        //Inserts a word into the trie
        public void Insert(string word)
        {
            TrieNode curr = root;
            for (int i = 0; i < word.Length; i++)
            {
                char c = word[i];
                if (curr.children[c - 'a'] == null)
                {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

        //Returns if the word is in the trie
        public bool Search(string word)
        {
            TrieNode curr = root;
            for (int i = 0; i < word.Length; i++)
            {
                char c = word[i];
                if (curr.children[c - 'a'] == null)
                {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
            return curr.isEnd;
        }
        //Returns if there is any word in the trie that starts with the given prefix
        public bool StartsWith(string prefix)
        {
            TrieNode curr = root;
            for (int i = 0; i < prefix.Length; i++)
            {
                char c = prefix[i];
                if (curr.children[c - 'a'] == null)
                {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
            return true;
        }
    }
}
