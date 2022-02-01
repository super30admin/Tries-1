public class Trie {

    class TrieNode
    {
        public bool IsEnd { get; set; }
        public TrieNode[] Children { get; set; }
        public TrieNode()
        {
            //given lowecase characters. Ask this in interview if not mentioned.
            Children = new TrieNode[26];
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
            if(curr.Children[c - 'a'] == null)
            {
                curr.Children[c - 'a'] = new TrieNode();
            }
            curr = curr.Children[c - 'a'];
        }
        curr.IsEnd = true;
    }
    
    public bool Search(string word) {
     TrieNode curr = root;
        for (int i = 0; i < word.Length; i++)
        {
            char c = word[i];
            if (curr.Children[c - 'a'] == null)
            {
               return false;
            }
            curr = curr.Children[c - 'a'];
        }
        return curr.IsEnd;
    }
    
    public bool StartsWith(string prefix) {
      TrieNode curr = root;
        for (int i = 0; i < prefix.Length; i++)
        {
            char c = prefix[i];
            if (curr.Children[c - 'a'] == null)
            {
                return false;
            }
            curr = curr.Children[c - 'a'];
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