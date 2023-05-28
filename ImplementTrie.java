// TC: O(Word length)
// SC: O(WOrd length) for TrieNode

class Trie {
    // TrieNode
    class TrieNode
    {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode()
        {
            children = new TrieNode[26];
            isEnd=false;
        }
    }
    TrieNode root;
    public Trie() {

    root = new TrieNode();
    }

    // Inserting a word in to Trie
    public void insert(String word) {
        // Reset current element to root
        TrieNode curr=root;
        // Traversing through word and checking at each node if the node of this character is present or null
        // If it is null created a new node and attached to it 
        for(int i=0;i<word.length();i++)
        {
             char c=word.charAt(i);
             if(curr.children[c-'a']==null)
             {
                 curr.children[c-'a']= new TrieNode();
             }
             curr=curr.children[c-'a'];
        }
        curr.isEnd=true;   
    }

    // Searching a word in Trie
    public boolean search(String word) {
        
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
             char c=word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                return false;
            }
            curr=curr.children[c-'a'];
        }

        return curr.isEnd;
        
    }
    
    // Searching prefix
    public boolean startsWith(String prefix) {
        TrieNode curr=root;

        for(int i=0;i<prefix.length();i++)
        {
             char c=prefix.charAt(i);
             if(curr.children[c-'a']==null)
             {
                 return false;
             }
             curr=curr.children[c-'a'];
        }
        return true;
        
    }
}
