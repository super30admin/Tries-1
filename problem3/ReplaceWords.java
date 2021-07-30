//Time Complexity : O(n), n -> Length of sentence
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
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

		// Add nodes to trie
		TrieNode root = new TrieNode();
		for (String word : dictionary) {
			TrieNode node = root;
			for (char ch : word.toCharArray()) {
				if (!node.containsKey(ch)) {
					node.put(ch, new TrieNode());
				}
				node = node.get(ch);
			}
			node.setWord();
		}

		StringBuilder sb = new StringBuilder();

		for (String word : sentence.split(" ")) {
			TrieNode node = root;
			boolean flag = true;
			StringBuilder curWord = new StringBuilder();
			int i = 0;
			for (i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				curWord.append(ch);
				if (node.get(ch) == null) {
					flag = false;
					break;
				}
				if (node.get(ch).isWord()) {
					break;
				}
				node = node.get(ch);
			}
			if (i != word.length()) {
				if (flag) {
					sb.append(curWord);
				} else {
					sb.append(word);
				}
			} else {
				sb.append(word);
			}
			sb.append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ReplaceWords obj = new ReplaceWords();
		List<String> dictionary = new ArrayList<>(Arrays.asList("cat", "bat", "rat"));
		String sentence = "the cattle was rattled by the battery";
		System.out.println("New sentence after replacing the words: " + obj.replaceWords(dictionary, sentence));
	}
}
