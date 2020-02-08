class TrieNode {
	TrieNode children[];
	boolean isEnd;

	public TrieNode() {
		children = new TrieNode[26];
		isEnd = false;
	}
}

public class Trie {
	TrieNode root;;

	public Trie() {
		root = new TrieNode();
	}

	void insert(String word) {
		TrieNode current = root;
		int size = word.length();
		for (int i = 0; i < size; i++) {
			int index = word.charAt(i) - 'a';
			if (current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			current = current.children[index];
		}
		current.isEnd = true;
	}

	/** Returns if the word is in the trie. */
	boolean search(String word) {
		TrieNode current = root;
		int size = word.length();
		for (int i = 0; i < size; i++) {
			int index = word.charAt(i) - 'a';
			if (current.children[index] == null) {
				return false;
			}
			current = current.children[index];
		}
		return current.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	boolean startsWith(String prefix) {
		TrieNode current = root;
		int size = prefix.length();
		for (int i = 0; i < size; i++) {
			int index = prefix.charAt(i) - 'a';
			if (current.children[index] == null) {
				return false;
			}
			current = current.children[index];
		}
		return true;
	}
}