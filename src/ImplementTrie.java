public class ImplementTrie {

	class TrieNode {

		boolean isEnd;
		TrieNode children[];

		public TrieNode() {
			children = new TrieNode[26];
		}

	}

	TrieNode root;

	/** Initialize your data structure here. */
	public ImplementTrie() {
		root = new TrieNode();

	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);

			if (curr.children[ch - 'a'] == null) {
				curr.children[ch - 'a'] = new TrieNode();
			}
			curr = curr.children[ch - 'a'];

		}
		curr.isEnd = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);

			if (curr.children[ch - 'a'] != null)
				curr = curr.children[ch - 'a'];
			else
				return false;

		}

		return curr.isEnd;

	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);

			if (curr.children[ch - 'a'] != null)
				curr = curr.children[ch - 'a'];
			else
				return false;

		}

		return true;

	}
}
