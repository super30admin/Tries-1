using System;
using System.Collections.Generic;
using System.Text;

namespace Tries
{
    class ReplaceWordsLC
    {
        //TC: O(nk + N) from dictionary + length of string
        //SC: O(nk + N) from trie + string builder

        class TrieNode
        {
            internal TrieNode[] children;
            internal bool isEnd;
            public TrieNode()
            {
                children = new TrieNode[26];
            }
        }
        TrieNode root;
        public void insert(string word)
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

        public string ReplaceWords(List<string> dictionary, string sentence)
        {
            if (sentence == null || sentence.Length == 0)
            {
                return sentence;
            }
            root = new TrieNode();
            foreach (string word in dictionary)
            {
                insert(word);
            }
            string[] strArray = sentence.Split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strArray.Length; i++)
            {
                if (i > 0)
                {
                    sb.Append(" ");
                }
                string word = strArray[i];
                StringBuilder replacement = new StringBuilder();
                TrieNode curr = root;
                for (int j = 0; j < word.Length; j++)
                {
                    char c = word[j];
                    if (curr.children[c - 'a'] == null || curr.isEnd)
                    {
                        break;
                    }
                    curr = curr.children[c - 'a'];
                    replacement.Append(c);
                }
                if (curr.isEnd)
                {
                    sb.Append(replacement);
                }
                else
                {
                    sb.Append(word);
                }
            }
            return sb.ToString();
        }
    }
}
