package com.javadwarf.trie.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _648_ReplaceWords {

	public class TrieNode {

		public Map<Character,TrieNode> map = null;
		public boolean endOfWord = false;

		public TrieNode() {
			map = new HashMap<>();
			endOfWord = false;
		}
	}

	TrieNode root = new TrieNode();

	public String replaceWords(List<String> dict, String sentence) {

		for(String rootWord : dict) {
			insert(rootWord);
		}

		String[] arr = sentence.split(" ");
		for (int i= 0; i<arr.length; i++) {
			String rootWord = search(arr[i]);
			arr[i] = rootWord.equals("") ? arr[i] : rootWord;
		}

		String res = "";
		for (int i= 0; i<arr.length; i++) {
			res += arr[i]+" ";
		}

		return res.trim();
	}

	public void insert(String word) {

		TrieNode curr = root;

		int i =0 ;
		while(i<word.length()) {
			Character ch = word.charAt(i);
			if(!curr.map.containsKey(ch)) {
				curr.map.put(ch, new TrieNode());
			}
			curr =curr.map.get(ch);
			i++;
		}
		curr.endOfWord = true;
	}

	public String search(String word) {
		TrieNode curr = root;

		String prefix = "";
		int i =0 ;
		while(i<word.length()) {
			if(curr.endOfWord) {
				return prefix;
			}
			Character ch = word.charAt(i);
			if(!curr.map.containsKey(ch)) {
				return "";
			}
			prefix += ch;
			curr = curr.map.get(ch);
			i++;
		}
		return prefix;
	}
}
