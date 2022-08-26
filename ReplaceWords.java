import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m*l) + O(n*k) where m = number of words in list, l = avg length of each word in list, n = number of words in array, k = avg length of each word in array
// Space Complexity : O(m*l) + O(n*k) where m = number of words in list, l = avg length of each word in list, n = number of words in array, k = avg length of each word in array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//648. Replace Words (Medium) - https://leetcode.com/problems/replace-words/
class Solution {

	class TrieNode {
		boolean isEnd;
		TrieNode[] children;

		public TrieNode() {
			children = new TrieNode[26];
		}
	}

	TrieNode root;

	public void insert(String word) {
		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);

			if (curr.children[ch - 'a'] == null) {
				curr.children[ch - 'a'] = new TrieNode();
			}

			curr = curr.children[ch - 'a'];
		}

		curr.isEnd = true;
	}

	public String replaceWords(List<String> dictionary, String sentence) {
		root = new TrieNode(); // O(m*l) where m = number of words in list, k = avg length of each word in list

		for (String root : dictionary) { // O(m*l) where m = number of words in list, k = avg length of each word in
											// list
			insert(root);
		}

		String[] sentenceArr = sentence.split(" "); // O(n*k) where n = number of words in array, k = avg length of each
													// word in array
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < sentenceArr.length; i++) {
			String successor = sentenceArr[i];
			StringBuilder replacement = new StringBuilder();
			TrieNode curr = root;
			if (i != 0)
				result.append(" ");
			for (int j = 0; j < successor.length(); j++) { // O(n*k) where n = number of words in array, k = avg
															// length of each word in array
				char ch = successor.charAt(j);

				if (curr.children[ch - 'a'] == null || curr.isEnd)
					break;
				replacement.append(ch);
				curr = curr.children[ch - 'a'];
			}

			if (curr.isEnd) {
				result.append(replacement);
			} else {
				result.append(successor);
			}
		}

		return result.toString();
	}
}