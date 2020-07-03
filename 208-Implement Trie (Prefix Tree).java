//Time Complexity=O(N)
//Space Coomplexity=O(N) as in worst case we have to add a new node at each insertion
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode()
        {
            children =new TrieNode [26];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0 ; i<word.length() ;i++)
        {
            char c=word.charAt(i);
            if(curr.children[ c - 'a'] ==null)// Checks whether the character in the TrieNode
                curr.children[c - 'a']=new TrieNode(); // If not then add a new TrieNode in it. 
            curr=curr.children[c - 'a']; //Go to next node
        }
        curr.isEnd=true; //It marks that the word is added to the Trie
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr=root;
        for(int i=0; i<word.length(); i++)
        {
            char c=word.charAt(i);
            if(curr.children[c-'a']==null)// Checks whether there is the character in the TrieNode
                return false; 
            curr=curr.children[c-'a'];
        }
        return curr.isEnd;      //Check if the word is found or its just the prefix 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++)
        {
            char c=prefix.charAt(i);
            if(curr.children[c-'a']==null)
                return false;
            curr=curr.children[c-'a'];
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