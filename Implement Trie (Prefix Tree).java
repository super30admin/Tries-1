// Time Complexity : insert: O(L) Search: O(L) Prefix: O(L)
// Space Complexity : insert: O(L) Search: O(1) Prefix: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
// Your code here along with comments explaining your approach
// For every trie node we will have a separate array of 26 nodes. It has a boolean isEnd variable to know where the word ends and it is considered as a valid word. The nodes where no characters are inserted are null nodes.

class Trie {
    class TrieNode
    {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode() 
        {
        this.children=new TrieNode[26];
        }
    }
    private TrieNode root;
    public Trie()
    {
        this.root=new TrieNode();
    }
    
    public void insert(String word) 
    {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(curr.children[c-'a']==null)// if there are no children then we initialize it with a new trienode
            {
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) 
    {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(curr.children[c-'a']==null) return false; //if the Trie doesn't have that character, it will return false
            curr=curr.children[c-'a'];
        }
        return curr.isEnd; //if IsEnd is true,then it is a valid word, otherwise it is not   
    }

//Prefix   
    public boolean startsWith(String prefix) 
    {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++)
        {
            char c= prefix.charAt(i);
            if(curr.children[c-'a']==null) return false;
            curr=curr.children[c-'a'];
        }
        return true; //It will come to this line only if it has not been false throughout the iteration
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */