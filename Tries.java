// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Tries {
    class TrieNode
    {
        boolean isEnd = false;
        TrieNode[] children;
        TrieNode()
        {
            children = new TrieNode[26];
        }
        List<String> prefix = new ArrayList<>();
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(int i =0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            int idx = c - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
            curr.prefix.add(word);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i =0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            int idx = c - 'a';
            if(curr.children[idx] == null)
                return false;
            curr = curr.children[idx];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i =0; i < prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if(curr.children[idx] == null)
                return false;
            curr = curr.children[idx];
        }
        return true;
    }
    public List<String> getPrefixes(String word)
    {
        TrieNode curr = root;
        for(int i =0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            int idx = c - 'a';
            if(curr.children[idx] == null)
                return null;
            else
                curr = curr.children[idx];
        }
        return curr.prefix;
    }
}
