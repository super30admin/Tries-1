package Q_720_Longest_Word_in_Dictionary;

import java.util.LinkedList;
import java.util.Queue;

//Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
//
//If there is no answer, return the empty string.
//Example 1:
//Input: 
//words = ["w","wo","wor","worl", "world"]
//Output: "world"
//Explanation: 
//The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
//Example 2:
//Input: 
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//Output: "apple"
//Explanation: 
//Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
//Note:
//
//All the strings in the input will only contain lowercase letters.
//The length of words will be in the range [1, 1000].
//The length of words[i] will be in the range [1, 30].
//

public class Solution {
	
	
	
	public class TrieNode{
		char nodeName;
		TrieNode[] children = new TrieNode[26];
		String word;
		boolean isWord;
		
		public TrieNode() {
		}
		
		public TrieNode(char name){
			this.nodeName = name;
		}
	}
	
	TrieNode root = new TrieNode();
	
	public void insertTrie(String word) {
		TrieNode curr = root;
		
		for(int i=0; i< word.length();i++) {
			char c = word.charAt(i);
			if(curr.children[c - 'a'] == null) {
				curr.children[c -'a'] = new TrieNode(c);
			}
			curr = curr.children[c - 'a'];
		}
		curr.word = word;
	}
	
	public String longestWord(String[] words) {
		for(String word : words) {
			insertTrie(word);
		}
		
		Queue<TrieNode> q = new LinkedList<>();
		q.add(root);
		TrieNode node = null;
		while(!q.isEmpty()) {
			node = q.poll();
			for(int i = 25; i>=0 ; i--) {
				if(node.children[i] !=null && node.children[i].word != null ) {
					q.add(node.children[i]);
				}
			}
		}
		
		return node.word;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		Solution s = new Solution();
		System.out.println(s.longestWord(words));

	}

}
