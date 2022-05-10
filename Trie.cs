using System;
using System.Collections.Generic;
using System.Text;

namespace Trie
{
    public class Trie
    {
        public class TrieNode
        {
            public TrieNode[] children;
            public bool isEnd;

            public TrieNode()
            {
                children = new TrieNode[26];
            }
        }

        public TrieNode root;
        public Trie()
        {
            root = new TrieNode();
        }

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
