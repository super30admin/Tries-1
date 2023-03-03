import java.util.HashMap;
import java.util.Map;

class Trie {
	Node root;

	public Trie() {
		root = new Node();
	}

	/**
	 * Since root is defined, we have to iterate each char and see if it is already
	 * present. If not, put it in the trie root's children and move that children
	 * node which is created.
	 * 
	 * TC: O(N) SC: O(1)
	 */
	public void insert(String word) {
		Node curr = root;
		for (char c : word.toCharArray()) {
			if (!curr.children.containsKey(c))
				curr.children.put(c, new Node());
			curr = curr.children.get(c);
		}
		curr.isWordEnded = true;
	}

	/**
	 * Similar to insertion, we iterate each char and see if it is present in the
	 * trie. If not return false. Else return true.
	 * 
	 * TC: O(N) SC: O(1)
	 */
	public boolean search(String word) {
		Node curr = root;
		for (char c : word.toCharArray()) {
			if (!curr.children.containsKey(c))
				return false;
			curr = curr.children.get(c);
		}
		return curr.isWordEnded;
	}

	/**
	 * Iterate over each char and if it is not present, then return false, else
	 * return true at the end of the prefix iteration.
	 * 
	 * TC: O(N) SC: O(1)
	 */
	public boolean startsWith(String prefix) {
		Node curr = root;
		for (char c : prefix.toCharArray()) {
			if (!curr.children.containsKey(c))
				return false;
			curr = curr.children.get(c);
		}
		return true;
	}
}

class Node {
	Map<Character, Node> children = new HashMap<>();
	boolean isWordEnded;
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
