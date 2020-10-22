package com.javadwarf.trie.leetcode;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class _720_LongestWordinDictionary {

	public static void main(String[] args) {

		//String x = new _720_LongestWordinDictionary().longestWord(new String[] {"w","wo","wor","worl", "world"});
		//String x = new _720_LongestWordinDictionary().longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"});
		String x = new _720_LongestWordinDictionary().longestWord(new String[] {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"});
		System.out.println(x);
	}

	public class TrieNode {

		public Map<Character,TrieNode> map = null;
		public boolean endOfWord = false;

		public TrieNode() {
			map = new TreeMap<>(Collections.reverseOrder());
			endOfWord = false;
		}
	}

	TrieNode root = new TrieNode();

	public String longestWord(String[] words) {
		insert("");
		for(String word : words) {
			insert(word);
		}
		return search(root,"","");
	}

	public void insert(String word){

		TrieNode curr = root;
		int i = 0; 

		while( i < word.length()){
			Character ch = word.charAt(i);
			if(!curr.map.containsKey(ch)) {
				curr.map.put(ch, new TrieNode());
			}
			curr = curr.map.get(ch);
			i++;
		}
		curr.endOfWord = true;
	}


	private String search(TrieNode curr, String result,  String currWord) {

		if(!curr.endOfWord) {
			return result ;
		}
		else if(result.length() <= currWord.length()) {
				result = currWord;
		}

		Set<Map.Entry<Character, TrieNode>> set = curr.map.entrySet();
		Iterator<Map.Entry<Character, TrieNode>> itr = set.iterator();
		while(itr.hasNext()) {
			Map.Entry<Character, TrieNode> e = itr.next();
			result = search(e.getValue(), result, currWord+e.getKey());
		}
		return result;
	}

}
