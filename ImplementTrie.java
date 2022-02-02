package tries1;

public class ImplementTrie {
	//Time Complexity : O(n), where n is length of word
	//Space Complexity : O(1), for internal stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	class TrieNode {
		TrieNode[] children;
	    boolean isEndOfWord;
	        
	    public TrieNode() {
	    	children = new TrieNode[26];
	        isEndOfWord = false;
	    }
	}

	TrieNode root;
	public ImplementTrie() {
		root = new TrieNode();
	}
	    
	public void insert(String word) {
		TrieNode curr = root;
	    for(char c: word.toCharArray()) {
	    	if(curr.children[c - 'a'] == null)
	    		curr.children[c - 'a'] = new TrieNode();
	        curr = curr.children[c - 'a'];
	    }
	    curr.isEndOfWord = true;
	}
	    
	public boolean search(String word) {
		TrieNode curr = root;
	    for(char c: word.toCharArray()) {
	    	if(curr.children[c - 'a'] == null)
	    		return false;
	        curr = curr.children[c - 'a'];
	    }
	    return curr.isEndOfWord;
	}
	    
	public boolean startsWith(String prefix) {
		TrieNode curr = root;
	    for(char c: prefix.toCharArray()) {
	    	if(curr.children[c - 'a'] == null)
	    		return false;
	        curr = curr.children[c - 'a'];
	    }    
	    return true;
	}
}
