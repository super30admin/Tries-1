
// Time Complexity : O(NL + ML), where N is number of words in dictionary and M is number of words in sentence and L is average length of word in dictionary and sentence
// Space Complexity: O(ML)
import java.util.*;

class Solution {
	TrieNode root;

	class TrieNode {
		boolean isEnd;
		TrieNode children[];

		public TrieNode() {
			children = new TrieNode[26];
		}
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new TrieNode();
			}
			curr = curr.children[c - 'a'];
		}
		curr.isEnd = true;
	}

	public String replaceWords(List<String> dict, String sentence) {
		root = new TrieNode();
		for (String s : dict) {
			insert(s);
		}
		String[] sentenceArr = sentence.split("\\s+");
		StringBuilder result = new StringBuilder();
		for (int k = 0; k < sentenceArr.length; k++) {
			String word = sentenceArr[k];
			if (k > 0)
				result.append(" ");
			TrieNode curr = root;
			StringBuilder replstr = new StringBuilder();
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (curr.children[c - 'a'] == null || curr.isEnd)
					break;
				replstr.append(c);
				curr = curr.children[c - 'a'];
			}
			if (curr.isEnd) {
				result.append(replstr);
			} else {
				result.append(word);
			}
		}
		return result.toString();
	}
}