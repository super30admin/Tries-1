// Time Complexity :O(nL), n is no of words in sentence with average length equal to that corresponding to the word in dictionary
// Space Complexity :O(nL), distinct words n of length l can be inserted in Trie
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* Store all words from dictionary in Trie  with TrieNode storing word as a attribute at the end character of the word
 * For every word in sentence, search in Trie till we find a character which has word attribute as not null, and replace the word in the sentence */

import java.util.*;
public class Replace_Words {
	class TrieNode{
		boolean isEnd;
		TrieNode[] children;

		public TrieNode(){
			children = new TrieNode[26];
		}
	}

	TrieNode root;
	/** Inserts a word into the trie. */
	public void insert(String word){
		TrieNode curr = root;
		for(int i=0; i<word.length(); i++){
			char c = word.charAt(i);
			if(curr.children[c - 'a'] == null){
				curr.children[c - 'a'] = new TrieNode();
			}
			curr = curr.children[c - 'a'];
		}
		curr.isEnd = true;
	}
	public String replaceWords(List<String> dict, String sentence) {
		root = new TrieNode();  // Initialize root a new trienode
		for(String word: dict)
			insert(word);   //built a trie

		String[] sentenceArray = sentence.split(" ");   // split sentence based on spaces in sentence arr
		StringBuilder result = new StringBuilder();
		for(int k=0; k< sentenceArray.length; k++){
			if(k > 0)
				result.append(" ");

			String word = sentenceArray[k];
			StringBuilder replaceString = new StringBuilder();
			TrieNode curr = root;
			for(int i=0; i<word.length(); i++){
				char c =word.charAt(i);
				if(curr.children[c - 'a'] == null || curr.isEnd)    // if word not found or we reached end
					break;

				replaceString.append(c);    // append to replace string, (one extra trienode initialized at end where isend is true and so we are appending later)
				curr = curr.children[c - 'a'];
			}   
			if(curr.isEnd)  // if we reached end i.e we found a replacement, append to result
				result.append(replaceString);
			else    // else append to word itself
				result.append(word);
		}
		return result.toString();
	}
}

/***********************Brute Force***************************/
//Time Complexity :O(n^2)
//Space Complexity :O(n)

class Replace_Words_Brute {
	public String replaceWords(List<String> dict, String sentence) {
		StringBuilder sb = new StringBuilder();
		String[] s = sentence.split(" ");
		for(String s1: s){
			for(String s2: dict){
				if(s1.startsWith(s2))
					s1 = s2;
			}
			sb.append(s1).append(" ");
		}
		return sb.toString().trim();
	}
}
