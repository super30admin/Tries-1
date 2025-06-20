/*
  Time complexity: Insert: O(n); Search: O(n); StartsWith: O(n);
  Space complexity: Insert: O(L); Search: O(1); StartsWith: O(1)

  Code ran successfully on Leetcode: Yes

*/

public class Trie {
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

    public Trie() {
        root = new TrieNode();
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
    
    public bool Search(string word) {
        TrieNode curr = root;
        foreach(char c in word)
        {
            if(curr.children[c-'a'] == null)
                return false;

            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }
    
    public bool StartsWith(string prefix) {
        TrieNode curr = root;
        foreach(char c in prefix)
        {
            if(curr.children[c-'a'] == null)
                return false;

            curr = curr.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.Insert(word);
 * bool param_2 = obj.Search(word);
 * bool param_3 = obj.StartsWith(prefix);
 */
