import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity of the algorithm is O(m*n) where m is no of words and n is max length per word
 * space Complexity will O(m*n) where  m is no of words and n is max length per word
 */
public class LongestWordinDictionary {

	class TrieNode {

		String word;
		TrieNode[] children;

		public TrieNode() {

			children = new TrieNode[26];
		}

	}

	TrieNode root;

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

		if (words == null || words.length == 0)
			return "";

		root = new TrieNode();

		for (String word : words) {

			insert(word);
		}

		TrieNode curr = root;
		Queue<TrieNode> q = new LinkedList();
		q.add(root);

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
		// TODO Auto-generated method stub

	}

}
