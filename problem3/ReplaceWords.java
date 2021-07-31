//Time Complexity : O(nk + l), n -> Number of words in dictionary, k -> Length of each word, l -> Length of sentence
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
	TrieNode root;

	public void insert(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			if (node.nodes[ch - 'a'] == null) {
				node.nodes[ch - 'a'] = new TrieNode();
			}
			node = node.nodes[ch - 'a'];
		}
		node.isWord = true;
	}

	/*************************************************************
	 * Store root words in a trie, then traverse sentence to replace words
	 *************************************************************/
	public String replaceWords(List<String> dictionary, String sentence) {
		if (sentence == null || sentence.length() == 0) {
			return "";
		}

		if (dictionary == null || dictionary.size() == 0) {
			return sentence;
		}

		root = new TrieNode();
		// Add nodes to trie
		for (String word : dictionary) {
			insert(word);
		}

		StringBuilder sb = new StringBuilder();

		for (String word : sentence.split("\\s+")) {
			TrieNode node = root;
			StringBuilder curWord = new StringBuilder();

			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (node.nodes[ch - 'a'] == null || node.isWord) {
					break;
				}
				curWord.append(ch);
				node = node.nodes[ch - 'a'];
			}

			if (node.isWord) {
				sb.append(curWord);
			} else {
				sb.append(word);
			}
			sb.append(" ");
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		ReplaceWords obj = new ReplaceWords();
		List<String> dictionary = new ArrayList<>(Arrays.asList("cat", "bat", "rat"));
		String sentence = "the cattle was rattled by the battery";
		System.out.println("New sentence after replacing the words: " + obj.replaceWords(dictionary, sentence));
	}
}
