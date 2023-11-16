public class LongestWordInDictionary
	{
        // Time Complexity : O(n * l), where n is the number of words in dictionary and l is the number of characters in each word
        // Space Complexity : O(n * l) - Trie space- where n is the number of words and l is the length of each word
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        String result;
        public string LongestWord(string[] words)
        {
            if (words == null || words.Count() == 0) return "";
            TrieNode root = new TrieNode();
            result = "";
            foreach (var word in words)
            {
                Insert(root, word);
            }
            dfs(root, new StringBuilder());
            return result;
        }

        public void dfs(TrieNode curr, StringBuilder path)
        {
            //base
            if(path.Length > result.Length)
            {
                result = path.ToString();
            }
            //logic
            for (int i = 0; i < 26; i++)
            {
                if (curr.children[i] != null && curr.children[i].isEnd)
                {
                    if (curr.children[i] != null && curr.children[i].isEnd)
                    {
                        //action
                        char c = (char)(i + 97);
                        path.Append(c);
                        //recurse
                        dfs(curr.children[i], path);
                        //backtrack
                        path.Remove(path.Length - 1, 1);
                    }

                }
            }
        }

        public class TrieNode
        {
            public bool isEnd;
            public TrieNode[] children;

            public TrieNode()
            {
                children = new TrieNode[26];
            }
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
