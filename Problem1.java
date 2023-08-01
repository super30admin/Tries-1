package Tries_1;

/**
 * Trie implementation
 * 
 * Time Complexity : insertion : O(n) - where n is the no of characters in the
 * word to be inserted search() : O(n) - where n is the no of characters in the
 * word to be inserted startsWith() : O(n) - where n is the no of characters in
 * the given string to be searched
 * 
 * Space Complexity : O(L), where L is the length of the largest word present in
 * the trie.
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */

public class Problem1 {
	class TrieNode {
		boolean flag;
		TrieNode[] children;

		TrieNode() {
			this.children = new TrieNode[26];
		}
	}

	TrieNode root;

	Problem1() {
		this.root = new TrieNode();

	}

	public void insert(String word) {
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new TrieNode();
			}
			curr = curr.children[c - 'a'];

		}

		curr.flag = true;
	}

	public boolean search(String word) {
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			if (curr.children[c - 'a'] == null)
				return false;
			curr = curr.children[c - 'a'];
		}
		return curr.flag;

	}

	public boolean startsWith(String prefix) {
		TrieNode curr = root;
		for (char c : prefix.toCharArray()) {
			if (curr.children[c - 'a'] == null)
				return false;
			curr = curr.children[c - 'a'];
		}
		return true;

	}

}
