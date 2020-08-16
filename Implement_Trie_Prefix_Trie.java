class Trie {
	//Approach: 1. Constructing a trie, for insert function, we can have a pointer for the root node and iterate over the word checking if the children of root for that character is null,
	//if so will create a trie node for that character and repeat it for the other characters in the string.
	//2. For searching , we will also iterate over the word and check if each character is in the trie node root as children if not return false or go till the end and check if
	//the last character has isEnd flag set.
	//3. For startwith function we do the same thing as search, but will not check for the isEnd flag.  
    TrieNode root;
    class TrieNode{
        boolean isEndOfWord;
        TrieNode[] children;
        TrieNode()
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
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null)
            {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEndOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null)return false;
            
            curr = curr.children[ch-'a'];
        }
        return curr.isEndOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++)
        {
            char ch = prefix.charAt(i);
            if(curr.children[ch - 'a'] == null)return false;
            
            curr = curr.children[ch-'a'];
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
//Time Complexity : O(l)  for l - length of the word. insert, search and startwith operations are O(l) since we have to iterate the whole word to do the operations.
//Space Complexity : O(nl)  - trie construction space for words.   
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :