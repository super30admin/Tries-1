

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No





import java.util.*;

public class LongestWord {

	TrieNode root;

	class TrieNode {
		TrieNode[] children;
		String word;

		TrieNode() {
			children = new TrieNode[26];
		}
	}

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
		root = new TrieNode();

		for (String word : words) {
			insert(word);
		}

		Queue<TrieNode> q = new LinkedList<>();
		q.add(root);
		TrieNode curr = null;

		while (!q.isEmpty()) {

			curr = q.poll();
			for (int i = 25; i >= 0; i--) {
				if (curr.children[i] != null && curr.children[i].word != null) {
					q.add(curr.children[i]);
				}
			}

		}

		return curr.word;

	}

	public static void main(String[] args) {

		LongestWord l = new LongestWord();
		String res = l.longestWord(new String[] { "w", "wo", "wor", "worl", "world" });
		System.out.println(res);
	}

}
