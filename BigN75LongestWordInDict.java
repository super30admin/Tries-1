// Time complexity is Not sure but exactly it will be
// Space complexity is  Not sure but exactly it will be
// This solution is submitted on leetcode

import java.util.LinkedList;
import java.util.Queue;

public class BigN75LongestWordInDict {
		class TrieNode {
			String word;
			TrieNode[] children = new TrieNode[26];
		}

		TrieNode root = new TrieNode();

		private void insert(String word) {
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

		public String longestWord(String[] words) {
			String result = "";
			// edge case
			if (words == null || words.length == 0)
				return result;
			for (String word : words) {
				insert(word);
			}
			Queue<TrieNode> q = new LinkedList<>();
			q.add(root);
			TrieNode curr = root;
			while (!q.isEmpty()) {
				curr = q.poll();
				for (int i = 25; i >= 0; i--) {
					if (curr.children[i] != null && curr.children[i].word != null)
						q.add(curr.children[i]);
				}
			}
			return curr.word;
		}
	}