package com.javadwarf.trie.leetcode.implementation;

import java.util.HashMap;
import java.util.Map;

public class _208_ImplementTrie_PrefixTree {

	public static void main(String[] args) {
		
		Trie obj = new Trie();
		
		obj.insertRec("abc");
		obj.insertRec("abgl");
		obj.insertRec("cdf");
		obj.insertRec("abcd");
		obj.insertRec("lmn");
		
		obj.deleteWordRec("abc");
		System.out.println(obj.startsWith("abc"));
		System.out.println(obj.search("abc"));
		obj.deleteWordRec("abgl");
		System.out.println(obj.search("abgl"));
		obj.deleteWordRec("abcd");
		System.out.println(obj.search("abcd"));
		
		System.out.println();
		
		
		
		
	}
}

 class Trie {

	public TrieNode root = null;

	public Trie() {
		root = new TrieNode();
	}

	/***** Insert, search, prefixSearch - Iterative approach *********************/
	//Insert takes O(n*m)
	//Searching for a key in a balanced tree costs O(mlogn) time complexity. m is key length, n number of keys

	public void insert(String word) {

		TrieNode curr = root;

		int i = 0;
		while(i < word.length()) {
			Character ch = word.charAt(i);

			if(!curr.map.containsKey(ch)) {
				TrieNode next = new TrieNode();
				curr.map.put(ch,next);
				curr = next;
			}
			else {
				curr = curr.map.get(ch);
			}
			i++;
		}
		curr.endOfWord = true; //when loop reaches the end of the word then at that time curr's end of word should be true
	}

	public boolean search(String word) {

		TrieNode curr = root;

		int i = 0;
		while(i < word.length()) {
			Character ch = word.charAt(i);
			if(!curr.map.containsKey(ch)) {
				return false;
			}
			curr = curr.map.get(ch);
			i++;
		}
		return curr.endOfWord;
	}

	public boolean startsWith(String prefix) {

		TrieNode curr = root;

		int i = 0;
		while(i < prefix.length()) {
			Character ch = prefix.charAt(i);
			if(!curr.map.containsKey(ch)) {
				return false;
			}
			curr = curr.map.get(ch);
			i++;
		}
		return true;
	}



	/********************* Insert, search, prefixSearch - Recursive approach *********************/


	public void insertRec(String word) {
		insertRec(word,root,0);
	}
	public void insertRec(String word, TrieNode curr, int index) {

		if(index == word.length()) {
			curr.endOfWord = true;
			return;
		}

		Character ch = word.charAt(index);

		if(!curr.map.containsKey(ch)) {
			TrieNode next = new TrieNode();
			curr.map.put(ch,next);
			curr = next;
		}
		else {
			curr = curr.map.get(ch);
		}
		insertRec(word,curr,index+1);
	}

	public boolean searchRec(String word) {
		return searchRec(word,root,0);

	}
	public boolean searchRec(String word, TrieNode curr, int index) {

		if(index == word.length()) {
			return curr.endOfWord;
		}

		Character ch = word.charAt(index);

		if(!curr.map.containsKey(ch)) {
			return false;
		}
		return searchRec(word, curr.map.get(ch), index+1);
	}

	public boolean startsWithRec(String prefix) {
		return startsWithRec(prefix, root, 0);
	}
	public boolean startsWithRec(String prefix, TrieNode curr, int index) {
		if(index == prefix.length()) return true;
		Character ch = prefix.charAt(index);
		if(!curr.map.containsKey(ch)) return false;
		return startsWithRec(prefix,curr.map.get(ch), index+1);
	}

	/*
	 During delete operation we delete the key in bottom up manner using recursion. 
	 The following are possible conditions when deleting key from trie,

             1. Key may not be there in trie. Delete operation should not modify trie.
             2. Key present as unique key (no part of key contains another key (prefix), 
               nor the key itself is prefix of another key in trie). Delete all the nodes.
             3. Key is prefix key of another long key in trie. Unmark the leaf node.
             4. Key present in trie, having at least one other key as prefix key,
               Delete nodes from end of key until first leaf node of longest prefix key.
	 */

	public void deleteWordRec(String word) {
		deleteWordRec(word,root,0);
	}

	public boolean deleteWordRec(String word, TrieNode curr, int index) {

		if(index == word.length()) {
			if(curr.map.size() > 0) {
				curr.endOfWord = false;
				return false; // false means no need to remove anything
			}
			else {
				return true; //true means, since size of map is empty , 
				//no other words are using the curr word as prefix 
				//to safe to delete the last letter 
			}
		}
		Character ch = word.charAt(index);
		if(curr.map.containsKey(ch)) {
			boolean temp = deleteWordRec(word, curr.map.get(ch), index+1);
			if(temp) {
				curr.map.remove(ch);
				if(curr.map.size() > 0) {
					curr.endOfWord = false;
					return false;
				}
				else {
					return true; 
				}
			}
		}
		return false;
	}
	
	//prefixDelete can also be deleted by above logic with slight modification 
}


 class TrieNode {
	
	public Map<Character,TrieNode> map = null;//if the string is only lower case letter then we can also use an array of 26 characters
	public boolean endOfWord = false;

	public TrieNode() {
		map = new HashMap<>();
		endOfWord = false;
	}

}


