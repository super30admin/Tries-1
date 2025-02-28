class Trie {
    class TrieNode
    {
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            children = new TrieNode[26]; 
            isEnd = false; 
        }
    }
private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
            char ch =word.charAt(i);
            if(curr.children[ch-'a'] == null)
            {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];

        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
         TrieNode curr = root;
          for(int i=0;i<word.length();i++)
        {
             char ch =word.charAt(i);
            if(curr.children[ch-'a'] == null)
            return false;
            curr = curr.children[ch-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
          for(int i=0;i<prefix.length();i++)
        {
             char ch =prefix.charAt(i);
            if(curr.children[ch-'a'] == null)
            return false;
            curr = curr.children[ch-'a'];
        }
        return true;
    }
}


//Time Complexity:
//Insert Method: O(l), where l is the length of the word being inserted.
//Search Method: O(l), where l is the length of the word being searched.
//StartsWith Method: O(p), where p is the length of the prefix.
//Space Complexity: O(n×l), 
//where:
//n is the number of words inserted into the Trie.
//l is the average length of the words.

