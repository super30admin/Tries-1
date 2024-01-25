// Time Complexity : O(length of string)
// Space Complexity : O(length of string)
// Method used : Tries

class Trie {

    class TrieNode
    {
        TrieNode[] node;
        boolean end;

        public TrieNode()
        {
            node = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() 
    {
        root = new TrieNode();
    }
    
    public void insert(String word) {

        TrieNode temp = root;
        
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);

            if(temp.node[c - 'a'] == null) temp.node[c - 'a'] = new TrieNode();

            temp = temp.node[c - 'a']; 
        }

        temp.end = true;
    }
    
    public boolean search(String word) {
        
        TrieNode temp = root;
        
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);

            if(temp.node[c - 'a'] == null) return false;

            temp = temp.node[c - 'a']; 
        }

        return temp.end;
    }
    
    public boolean startsWith(String prefix) {
        
        TrieNode temp = root;
        
        for(int i = 0; i < prefix.length(); i++)
        {
            char c = prefix.charAt(i);

            if(temp.node[c - 'a'] == null) return false;

            temp = temp.node[c - 'a']; 
        }

        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */