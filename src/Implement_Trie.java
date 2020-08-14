//Trie(Prefix Tree)
// Time Complexity : O(N), length of the word
// Space Complexity : O(nL), as distinct words n of length l can be inserted
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Implement_Trie {
	/** Initialize your data structure here. */
	class TrieNode{
		TrieNode children[];    //to track the word by initializing a new trie node type array at the index of the word
		boolean isEnd;  //to track whether we have reached end of a string

		public TrieNode(){
			children = new TrieNode[26];    //initialzed to trienode array of 26
		}
	}
	TrieNode root;
	public Implement_Trie(){
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */	/**TC: O(N) , SC: O(N)**/
	public void insert(String word) {
		TrieNode curr = root;   
		for(int i=0; i<word.length(); i++){
			char c = word.charAt(i);
			if(curr.children[c - 'a'] == null)  // c-'a' gives the position of character from 0 to 25 and checks whether that character node is null or not
				curr.children[c - 'a'] = new TrieNode();    //if null then create a new node of 26 characters again

			curr = curr.children[c - 'a']; //current node
		}
		curr.isEnd = true; // at the last character node its end of the word
	}

	/** Returns if the word is in the trie. */	/**TC: O(N) , SC: O(1)**/
	public boolean search(String word) {
		TrieNode curr = root;  
		for(int i=0; i<word.length(); i++){
			char c = word.charAt(i);
			if(curr.children[c - 'a'] == null)  // if the current character node is not found to be null in the trie
				return false;

			curr = curr.children[c - 'a'];  //current node
		}
		return curr.isEnd;  // checks whether a character node is end of the word or not
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */ /**TC: O(N) , SC: O(1)**/
	public boolean startsWith(String prefix) {
		TrieNode curr = root;  
		for(int i=0; i<prefix.length(); i++){
			char c = prefix.charAt(i);
			if(curr.children[c - 'a'] == null)
				return false; 

			curr = curr.children[c - 'a'];
		}
		return true;    // it doesn't require EndOfWord to be true, as the word searched is a prefix of a word in the trie
	}
}
