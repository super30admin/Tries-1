package com.exmaple.problems;

import java.util.LinkedList;
import java.util.Queue;

public class LongestWord {

	TrieNode root = new TrieNode();

	public void insert(String word) {
		TrieNode cur = root;
		int size = word.length();
		for (int i = 0; i < size; i++) {
			int index = word.charAt(i) - 'a';
			if (cur.children[index] == null) {
				cur.children[index] = new TrieNode();
			}
			cur = cur.children[index];
		}
		cur.word = word;

	}

	public String longestWord(String[] words) {
		for (String word : words) {
			insert(word);
		}
		Queue<TrieNode> queue = new LinkedList<>();
		queue.add(root);
		TrieNode node = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			for (int i = 25; i >= 0; i--) {
				if (node.children[i] != null && node.children[i].word != null) {
					queue.add(node.children[i]);
				}
			}
		}
		return node.word;
	}

	public static void main(String args[]) {
		String words[] = { "w", "wo", "wor", "worl", "world" };
		System.out.println(new LongestWord().longestWord(words));
	}
}
