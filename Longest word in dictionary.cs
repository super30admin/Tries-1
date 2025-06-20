/*
  Time complexity: O(n*L)
  Space complexity: O(n*L)

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

    public Solution() {
        root = new TrieNode();
        result = new();
        root.isEnd = true;
    }
    
    public void Insert(string word) {
        TrieNode curr = root;
        foreach(char c in word)
        {
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();

            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    StringBuilder result;
    public string LongestWord(string[] words) {
        foreach(string word in words)
        {
            Insert(word);
        }
        helper(root, new StringBuilder());
        return result.ToString();
    }

    private void helper(TrieNode root, StringBuilder sb)
    {
        //base
        if(root==null || !root.isEnd)
        {
            return;
        }
        if(sb.Length>result.Length)
        {
            result = new StringBuilder(sb.ToString());
        }
        //logic
        
        int index = 0;
        foreach(TrieNode child in root.children)
        {
            if(child!=null && child.isEnd)
            {
                sb.Append((char)(index+'a'));
                helper(child, sb);
                sb.Remove(sb.Length-1,1);
            }
            index++;
        }
        
    }
}
