public class Trie
    {
        // Time Complexity : Insert : O(l), Search(): O(l), StartsWith(): O(l) - where l is the length of the word
        // Space Complexity : Insert : O(n*l), Search(): O(n*l), StartsWith(): O(n*l) - where n is the number of words and l is the length of each word
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        TrieNode root;

        public class TrieNode
        {
            public bool isEnd;
            public TrieNode[] children;

            public TrieNode()
            {
                children = new TrieNode[26];
            }
        }
        public Trie()
        {
            root = new TrieNode();   
        }

        public void Insert(string word)
        {
            TrieNode curr = root;
            for(int i = 0; i < word.Length; i++)
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
            for(int i = 0; i < word.Length; i++)
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
            for(int i = 0; i < prefix.Length; i++)
            {
                char c = prefix[i];
                if (curr.children[c - 'a'] == null)
                    return false;

                curr = curr.children[c - 'a'];
            }
            return true;
        }
    }
