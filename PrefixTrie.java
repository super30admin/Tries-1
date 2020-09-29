// TC: O(N) for insert, search and startsWith
// SC: O(1) for search and StartsWith and O(N) for insertion operation

class TrieNode{
	
	TrieNode[] children;
	boolean isWordEnd;
	
	TrieNode(){
		children = new TrieNode[26];
		isWordEnd = false;
	}
}

public class PrefixTrie {
	
	TrieNode node = new TrieNode();

	public void insert(String word) {
		
		TrieNode root = node;
		for(char ch: word.toCharArray()){
			if(root.children[ch - 'a'] == null) {
				root.children[ch-'a'] = new TrieNode();
			}
			root = root.children[ch -'a'];
		}
		root.isWordEnd = true;
	}
	
	public boolean search(String word) {
		
		TrieNode root = node;
		
		for(char ch: word.toCharArray()){
			if(root.children[ch - 'a'] == null) {
				return false;
			}
			root = root.children[ch -'a'];
		}
		return root.isWordEnd;
	}

	public boolean startsWith(String word) {
		
		TrieNode root = node;
		
		for(char ch: word.toCharArray()){
			if(root.children[ch - 'a'] == null) {
				return false;
			}
			root = root.children[ch -'a'];
		}
		return true;
	}
}
