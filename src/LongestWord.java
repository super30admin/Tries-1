//Time Complexity : O(N*K) N = total words, K = highest word length
//Space Complexity : O(K * 26)  K = highest word length.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * First construct trie out of the given words. then, apply dfs on the trie.
 * What it does is, it will iterate each node of trie and see if it is a full
 * word. If so, it updates the result string when it is greater than the result
 * string. final return result. (Took reference from discussion forum)
 *
 */
class Solution {
	private Node root;
	private String result = "";

	public String longestWord(String[] words) {
		root = new Node();

		for (String w : words)
			insert(w);

		dfs(root);

		return result;
	}

	private void dfs(Node node) {
		if (node == null)
			return;

		if (node.word != null) {
			if (node.word.length() > result.length())
				result = node.word;
			else if (node.word.length() == result.length() && node.word.compareTo(result) < 0)
				result = node.word;
		}

		for (Node child : node.children)
			if (child != null && child.word != null)
				dfs(child);
	}

	private void insert(String word) {
		Node current = root;
		for (char c : word.toCharArray()) {
			if (current.children[c - 'a'] == null)
				current.children[c - 'a'] = new Node();
			current = current.children[c - 'a'];
		}
		current.word = word;
	}

}

class Node {
	Node[] children = new Node[26];
	String word;

}