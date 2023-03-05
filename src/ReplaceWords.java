import java.util.List;
//Time Complexity : O(N*K) N = total words, K = highest word length
//Space Complexity : O(K * 26)  K = highest word length.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Construct trie from the given words. Split the sentence into words and check
 * for each word, if there is any prefix for that word. If so return that
 * prefix, else return the whole word. Append these prefixes to the result
 * string and return the result.
 *
 */
class Solution {
	Node root = new Node();

	public String replaceWords(List<String> dictionary, String sentence) {
		for (String word : dictionary) {
			insert(word);
		}

		String[] words = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			String ans = getPrefix(word);
			sb.append(ans).append(" ");
		}

		return sb.toString().trim();
	}

	private String getPrefix(String word) {
		Node current = root;
		if (current.children[word.charAt(0) - 'a'] == null)
			return word;
		StringBuilder sb = new StringBuilder();
		for (char c : word.toCharArray()) {
			if (current.children[c - 'a'] == null)
				return word;
			else {
				sb.append(c);
				if (current.children[c - 'a'].isWordEnded) {
					return sb.toString();
				} else {
					current = current.children[c - 'a'];
				}
			}
		}
		return word;
	}

	private void insert(String word) {
		Node current = root;
		for (char c : word.toCharArray()) {
			if (current.children[c - 'a'] == null)
				current.children[c - 'a'] = new Node();
			current = current.children[c - 'a'];
		}
		current.isWordEnded = true;
	}
}

class Node {
	Node[] children = new Node[26];
	boolean isWordEnded;
}