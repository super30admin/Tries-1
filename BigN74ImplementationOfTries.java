// Time Complexity is O(n)
// Space complexity is O(n) or O(1) not sure because we are creating a 26 character array, but many of them as nested -> please let me know space complexity 
// This solution is submitted on leetcode

public class BigN74ImplementationOfTries {
	class TrieNode {
		boolean isEnd;
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
		curr.isEnd = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (curr.children[c - 'a'] == null)
				return false;
			curr = curr.children[c - 'a'];
		}
		return curr.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (curr.children[c - 'a'] == null)
				return false;
			curr = curr.children[c - 'a'];
		}
		return true;
	}
}