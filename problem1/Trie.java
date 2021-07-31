//Time Complexity : INSERT: O(n); SEARCH: O(n); STARTSWITH: O(n), n = Word length
// Space Complexity : INSERT: O(n); SEARCH: O(1); STARTSWITH: O(1), n = Word length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class Trie {
	Node root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new Node();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Node node = root;
		for (char ch : word.toCharArray()) {
			if (!node.containsKey(ch)) {
				node.put(ch, new Node());
			}
			node = node.get(ch);
		}
		node.setWord();
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Node node = root;
		for (char ch : word.toCharArray()) {
			if (!node.containsKey(ch)) {
				return false;
			}
			node = node.get(ch);
		}
		return node != null && node.isWord();
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Node node = root;
		for (char ch : prefix.toCharArray()) {
			if (!node.containsKey(ch)) {
				return false;
			}
			node = node.get(ch);
		}
		return node != null;
	}

	public static void main(String[] args) {
		Trie obj = new Trie();
		obj.insert("apple");
		System.out.println(obj.search("apple"));
		System.out.println(obj.search("app"));
		System.out.println(obj.startsWith("app"));
		obj.insert("app");
		System.out.println(obj.search("app"));
	}

}
