package Q_208_Implement_Trie;


//Implement a trie with insert, search, and startsWith methods.
//
//Example:
//
//Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // returns true
//trie.search("app");     // returns false
//trie.startsWith("app"); // returns true
//trie.insert("app");   
//trie.search("app");     // returns true
//Note:
//
//You may assume that all inputs are consist of lowercase letters a-z.
//All inputs are guaranteed to be non-empty strings.

//Time Complexity  : O(n)  n = size of word

//Space Complexity : O(1)


class Trie {
	
	class TrieNode{
		char nameValue;
		TrieNode[] children = new TrieNode[26];
		boolean isEnd;
		
		public TrieNode() {
		}
		
		public TrieNode(char name)
		{
			this.nameValue = name;
		}
	}

	TrieNode root = new TrieNode();
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode curr = root;
    	for(int i=0; i <word.length();i++) {
    		char c = word.charAt(i);
    		if(curr.children[c - 'a'] == null) {
    			curr.children[c - 'a'] = new TrieNode(c);
    		}
    			curr = curr.children[c - 'a'];
    	}
    	curr.isEnd = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode curr = root;
    	for(int i=0 ; i< word.length();i++) {
    		char c = word.charAt(i);
    		
    		if(curr.children[c - 'a'] == null) {
    			return false;
    		}
    		curr =curr.children[c - 'a'];
    	}

    	return curr.isEnd;
    	
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode curr = root;
    	for(int i=0;i<prefix.length();i++)
    	{
    		char c = prefix.charAt(i);
    		if(curr.children[c - 'a'] == null) {
    			return false;
    		}
    		curr = curr.children[c - 'a'];
    	}
    	
    	
    	
    	return true;
        
    }
    public static void main(String[] args) {
    	
    	String word = "apple";
    	String prefix = "pp";
    	
    	  Trie obj = new Trie();
    	  obj.insert(word);
    	  boolean param_2 = obj.search(word);
    	  boolean param_3 = obj.startsWith(prefix);
    	 
    	  System.out.println(param_2);
    	  System.out.println(param_3);

	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

