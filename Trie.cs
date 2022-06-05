// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
	// 1) We build tree, maximum of 26 characters nodes
	// 2) And then each node can have maximum 26 charcter nodes further
	// 3) Searching at every node will be O(1) because u can use hashset for searching
	// 4) So search for string would be O(n) - n is length of string
	// 5) Trie class will have triw array for childer and isEnd boolean to see f its end of any word


public class Trie {

    public class TrieNode{
        public TrieNode[] children;
        public bool isEnd;
        
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();    
    }
    
    public void Insert(string word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.Length; i++)
        {
            char c = word[i];
            if(curr.children[c - 'a'] == null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public bool Search(string word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.Length; i++)
        {
            char c = word[i];
            if(curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        
        if(curr.isEnd)
            return true;
        
        return false;
    }
    
    public bool StartsWith(string prefix) {
        TrieNode curr = root;
        
        for(int i = 0; i < prefix.Length; i++)
        {
            char c = prefix[i];
            if(curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
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