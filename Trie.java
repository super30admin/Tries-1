// Time Complexity : Insert:O(L),Search:O(L),startswith:O(L) // L is length of string. at every char we have 3 choices
// Space Complexity :Insert:O(L),Search:O(1),startswith:O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


/*
 * 1. each trie node contains array of children's. 
 * 2. each word last char will be marked with is end as true.
 */

public class Trie {
	class TrieNode {
		boolean isEnd;
		TrieNode[] childs;

		public TrieNode() {
			childs = new TrieNode[26];
		}
	}

	/** Initialize your data structure here. */
	TrieNode root;

	public Trie() {
        root= new TrieNode();
    }

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.childs[c - 'a'] == null) {
				cur.childs[c - 'a'] = new TrieNode();

			}
			cur = cur.childs[c - 'a'];
		}
		cur.isEnd = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.childs[c - 'a'] == null) {
				return false;
			}
			cur = cur.childs[c - 'a'];
		}
		return cur.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (cur.childs[c - 'a'] == null) {
				return false;
			}
			cur = cur.childs[c - 'a'];
		}
		return true;
	}
}
