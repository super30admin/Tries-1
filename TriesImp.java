//TC: insert O(n), search: O(n) prefix: O(n)
//SC: insert O(n), search: O(1) prefix: O(1)
//executed on leetcode.
class Trie {

    class TrieNode{
        TrieNode[] children;
        boolean isWord;			//Created a data structure for every character of the alphabet.
        
        public TrieNode()		//isWord represent that the word it is end of a word.
        {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();         
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {		//checks the tiernode DS and if the particular char is not null adding the child(Trie Node to the present value)
        
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)	//At the end make the entire null trienode, set isWord as true. 
        {
            if(curr.children[word.charAt(i)-'a']==null)
                curr.children[word.charAt(i)-'a'] = new TrieNode();
            curr = curr.children[word.charAt(i)-'a'];
        }        
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {        
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)		//If the trie node isWord value at the end is false, it says word doesn't exists. If true, exists
        {										//Even in between anychar is missing just return false
            if(curr.children[word.charAt(i)-'a']==null)
                return false;            
            curr = curr.children[word.charAt(i)-'a'];            
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++)
        {											//If the trie node has the child for the char value till the end of string return true,
            if(curr.children[prefix.charAt(i)-'a']==null)	//In between any char is missing just return false
                return false;
            curr = curr.children[prefix.charAt(i)-'a'];
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