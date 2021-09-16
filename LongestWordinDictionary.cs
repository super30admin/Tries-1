using System;
using System.Collections.Generic;
using System.Text;

namespace Tries
{
    class LongestWordinDictionary
    {
        //TC: O(nk)
        //SC: O(nk)
        class TrieNode
        {
            internal TrieNode[] children;
            internal string word;
            public TrieNode()
            {
                children = new TrieNode[26];
            }
        }
        TrieNode root;
        private void insert(string word)
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
            curr.word = word;
        }

        public string LongestWord(string[] words)
        {
            if (words == null || words.Length == 0)
            {
                return "";
            }
            root = new TrieNode();
            foreach (string word in words)
            {
                insert(word);
            }
            //BFS
            Queue<TrieNode> q = new Queue<TrieNode>();
            TrieNode curr = root;
            q.Enqueue(root);
            while (q.Count != 0)
            {
                curr = q.Dequeue();
                for (int i = 25; i >= 0; i--)
                {
                    if (curr.children[i] != null && curr.children[i].word != null)
                    {
                        q.Enqueue(curr.children[i]);
                    }
                }
            }
            return curr.word;
        }
    }
}
