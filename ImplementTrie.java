

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


public class ImplementTrie {
	
	TrieNode root;

	class TrieNode{
		TrieNode[] children;
		boolean isEnd;
		
		private TrieNode(){
			children = new TrieNode[26];
		}
	}
	 /** Initialize your data structure here. */
    public ImplementTrie() {
    	
    	root = new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	
    	TrieNode curr = root;
    	for(int i=0; i<word.length(); i++) {
    		char c = word.charAt(i);
    		if(curr.children[c-'a'] == null) {
    			curr.children[c-'a'] = new TrieNode();
    			
    		}
    		curr = curr.children[c-'a'];
    		
    	}
    	
    	
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	
    	TrieNode curr = root;
    	
    	for(int i=0; i<word.length(); i++) {
    		char c = word.charAt(i);
    		
    		if(curr.children[c-'a'] == null) {
    			return false;
    		}
    		curr = curr.children[c-'a'];
    	}
    	
    	return curr.isEnd;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	
    	
    	TrieNode curr = root;
    	
    	for(int i=0; i<prefix.length(); i++) {
    		char c = prefix.charAt(i);
    		if(curr.children[c-'a'] == null) {
    			return false;
    		}
    		curr = curr.children[c-'a'];
    	}
    	
    	
    	return true;
        
    }
    
    

	public static void main(String[] args) {
		ImplementTrie trie = new ImplementTrie();

		trie.insert("apple");
		trie.search("apple");   // returns true
		trie.search("app");     // returns false
		trie.startsWith("app"); // returns true
		trie.insert("app");   
		trie.search("app");  

	}

}
