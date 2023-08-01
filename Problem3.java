package Tries_1;

/*
 * We put the given words from the dictionary into a trie data structure and for each word in the sentence we search the trie 
 * for the shortest length replacement. If found we replace it else we use the current word itself
 * 
 * Time Complexity :
 * O((n+m)*l) - where n is the no of words in the string, m is the no of words in the dictionary and l is the avg length of words
 * 
 * Space Complexity :
 * O(L), where L is the length of the largest word present in the dictionary.
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
import java.util.List;

public class Problem3 {
	class Trie {
		class TrieNode {
			boolean flag;
			TrieNode[] children;

			TrieNode() {
				this.children = new TrieNode[26];
			}
		}

		TrieNode root;

		public Trie() {
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

		public Boolean search(String word) {
			TrieNode curr = root;
			for (char c : word.toCharArray()) {
				if (curr.children[c - 'a'] == null)
					return null;
				curr = curr.children[c - 'a'];
			}
			return curr.flag;

		}

	}

	public String replaceWords(List<String> dictionary, String sentence) {
		Trie trie = new Trie();
		StringBuilder result = new StringBuilder();
		for (String s : dictionary) {
			trie.insert(s);
		}
		for (String s : sentence.split(" ")) {
			StringBuilder replace = new StringBuilder();
			for (char c : s.toCharArray()) {
				replace.append(c);

				if (null == trie.search(replace.toString())) {
					break;
				} else if (trie.search(replace.toString()))
					break;
			}
			if (trie.search(replace.toString()) == null)
				result.append(s + " ");
			else
				result.append(replace + " ");

		}
		return result.toString().trim();
	}

}
