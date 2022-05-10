using System;
using System.Collections.Generic;
using System.Text;

namespace Trie
{
    public class ReplaceWord
    {
        /*
         * T.C & S.C O(M*L) + O(N*K) 
         * where M is number of words in the sentence and L is avg length of each word 
         * N is number of words in disctionary and N is avg length of each word 
         * 
         */
        public class TrieNode
        {
            public TrieNode[] children;
            public bool isEnd;

            public TrieNode()
            {
                children = new TrieNode[26];
            }
        }

        TrieNode root = new TrieNode();

        private void Insert(string word)
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

        public string ReplaceWords(IList<string> dictionary, string sentence)
        {

            StringBuilder result = new StringBuilder();

            foreach (string word in dictionary)
            {
                Insert(word);
            }

            string[] strArray = sentence.Split(" ");

            for (int i = 0; i < strArray.Length; i++)
            {
                if (i != 0)
                {
                    result.Append(" ");
                }
                TrieNode curr = root;

                string word = strArray[i];

                StringBuilder newStr = new StringBuilder();

                for (int j = 0; j < word.Length; j++)
                {
                    char c = word[j];
                    if (curr.children[c - 'a'] == null || curr.isEnd)
                    {
                        break;
                    }
                    curr = curr.children[c - 'a'];
                    newStr.Append(c);
                }

                if (curr.isEnd)
                {
                    result.Append(newStr.ToString());
                }
                else
                {
                    result.Append(word);
                }

            }
            return result.ToString();

        }
    }
}
