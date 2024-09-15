import java.util.LinkedList;
import java.util.Queue;

public class LongestWord {
	TrieNode root = new TrieNode();

	class TrieNode {
		String word;
		boolean isEnd;
		TrieNode[] children = new TrieNode[26];
	}

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

	public String longestWord(String[] words) {
		for (String s : words) {
			insert(s);
		}
		Queue<TrieNode> q = new LinkedList<>();
		q.add(root);
		TrieNode node = null;
		while (!q.isEmpty()) {
			node = q.poll();
			for (int i = 25; i >= 0; i--) {
				if (node.children[i] != null && node.children[i].word != null) {
					q.add(node.children[i]);
				}
			}
		}
		return node.word;
	}
}