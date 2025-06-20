/*
  Time complexity: O(N*l + M*l)
  Space complexity: O(N*l + M*l)

  Code ran successfully on Leetcode: Yes
*/

public class Solution {
    public class TrieNode{
        public bool isEnd;
        public TrieNode[] children;

        public TrieNode()
        {
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public Solution()
    {
        root = new TrieNode();
    }
    public string ReplaceWords(IList<string> dictionary, string sentence) {
        StringBuilder sb = new StringBuilder();
        string[] words = sentence.Split(" ");
        foreach(string word in dictionary)
        {
            Insert(word);
        }

        foreach(string w in words)
        {
            StringBuilder temp = new();
            TrieNode curr = root;
            foreach(char c in w)
            {
                if(curr.children[c-'a']==null || curr.isEnd==true)
                    break;
                temp.Append(c);
                curr = curr.children[c-'a'];
            }
            if(!curr.isEnd)
            {
                temp = new StringBuilder(w);
            }
            sb.Append(temp);
            sb.Append(" ");
        }
        return sb.ToString().Trim();
    }
    
    private void Insert(string word) {
        TrieNode curr = root;
        foreach(char c in word)
        {
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();

            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
}

