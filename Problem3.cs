public class Solution
	{
        // Time Complexity : O(n * l) + O(m * l), where n is the number of words in dictionary, m is the number of words in the sentence and l is the number of characters in each word
        // Space Complexity : O(n * l) - Trie space- where n is the number of words and l is the length of each word
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        public class TrieNode
        {
            public bool isEnd;
            public TrieNode[] children;

            public TrieNode()
            {
                children = new TrieNode[26];
            }
        }
        public string ReplaceWords(IList<string> dictionary, string sentence)
        {
            TrieNode root = new TrieNode();
            foreach (var word in dictionary)
            {
                Insert(root, word);
            }

            string[] strArr = sentence.Split(" ");
            StringBuilder result = new StringBuilder();
            //go over the string array of words
            for(int k = 0; k < strArr.Length; k++)
            {
                TrieNode curr = root;
                string word = strArr[k];
                if(k > 0)
                {
                    //add space to result everytime we process each word except at the first word
                    result.Append(" ");
                }
                StringBuilder replacementWord = new StringBuilder();
                for(int i = 0; i < word.Length; i++)
                {
                    char c = word[i];
                    //we will break from each word, if we dont find char in trie or found entire word if we reached end of trie
                    if (curr.children[c - 'a'] == null || curr.isEnd)
                    {
                        break;
                    }
                    curr = curr.children[c - 'a']; //move to next node
                    replacementWord.Append(c);
                }
                if(curr.isEnd)
                {
                    //we found the replacement
                    result.Append(replacementWord);
                }
                else
                {
                    result.Append(word);
                }
            }
            return result.ToString();
        }

        public void Insert(TrieNode root, string word)
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
    }
