//Time & Space Complexity
//insert => O(n)
//search => O(n)
//prefix => O(n)

class Trie {
    TrieNode root;
    
    class TrieNode{
        boolean isEnd;
        each child node is an array of 26 characters
        TrieNode[] children;
        
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            //if we reach till the end insert a new node
            if(curr.children[c-'a']== null)
                curr.children[c-'a'] = new TrieNode();
            //otherwise iterate through Trie until we reach last node
            curr = curr.children[c-'a'];
        }
        
        //after processing the whole string
        curr.isEnd = true;  
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            //if children == null not all the characters are present in Trie so return false
            if(curr.children[c-'a'] == null)
                return false;
            //move to next node
            curr = curr.children[c-'a'];
        }
        //if the word is found, check its isEnd status
        return curr.isEnd;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0; i<prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if(curr.children[c-'a']==null)
                return false;
            else
                curr = curr.children[c-'a'];
        }
        return true;
    }
}
