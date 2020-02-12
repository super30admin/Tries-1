//Time complexity is
//Space complexity is 
//This solution is submitted on leetcode

import java.util.List;

public class BigN76ReplaceWords {
	class TrieNode {
		String word;
		TrieNode[] children = new TrieNode[26];
	}

	TrieNode root = new TrieNode();

	public void insert(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new TrieNode();
			}
			curr = curr.children[c - 'a'];
		}
		curr.word = word;
	}

	public String replaceWords(List<String> dict, String sentence) {
		for (String word : dict) {
			insert(word);
		}
		StringBuilder sb = new StringBuilder();
		for (String word : sentence.split(" ")) {
			if (sb.length() > 0)
				sb.append(" ");
			TrieNode curr = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (curr.children[c - 'a'] == null || curr.word != null)
					break;
				curr = curr.children[c - 'a'];
			}
			String replacement = curr.word;
			if (replacement == null) {
				sb.append(word);
			} else {
				sb.append(replacement);
			}
		}
		return sb.toString();
	}
}