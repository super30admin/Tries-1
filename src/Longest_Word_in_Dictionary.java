// Time Complexity : O(nL + n*26) = O(nL), prefix length
// Space Complexity : O(nL), distinct words n of length l can be inserted
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/** Store all words in a Trie structure
 *  BFS is used to find out the longest word**/

import java.util.*;
class Solution {
	TrieNode root;
	class TrieNode{
		TrieNode children[];    //to track the word by initializing a new trie node type array at the index of the word
		String word;

		public TrieNode(){
			children = new TrieNode[26];    //initialzed to trienode array of 26
		}
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode curr = root;   
		for(int i=0; i<word.length(); i++){
			char c = word.charAt(i);
			if(curr.children[c - 'a'] == null)  // c-'a' gives the position of character from 0 to 25 and checks whether that character node is null or not
				curr.children[c - 'a'] = new TrieNode();    //if null then create a new node of 26 characters again

			curr = curr.children[c - 'a']; //current node
		}
		curr.word = word; // store the word when we reach the end
	}	
	
	public String longestWord(String[] words) {
		root = new TrieNode();
		for(String word: words)
			insert(word);	//insert all words into the trie

		Queue<TrieNode> q = new LinkedList<>();
		q.add(root);
		TrieNode curr = null;

		while(!q.isEmpty()){
			curr = q.poll();
			for(int i=25; i>=0; i--){	//check all index, adding reverse lexicographically to queue
				if(curr.children[i] != null && curr.children[i].word != null)	// if there is a character and we found the end of the word
					q.add(curr.children[i]);	//add the child node to queue
			}
		}
		return curr.word;	//return word corresponding to the last character left in queue
	}
}