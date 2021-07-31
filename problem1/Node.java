package problem1;

public class Node {
	private Node[] nodes;
	private boolean isWord;

	public Node() {
		nodes = new Node[26];
	}

	public boolean containsKey(char ch) {
		return nodes[ch - 'a'] != null;
	}

	public Node get(char ch) {
		return nodes[ch - 'a'];
	}

	public void put(char ch, Node node) {
		nodes[ch - 'a'] = node;
	}

	public void setWord() {
		isWord = true;
	}

	public boolean isWord() {
		return isWord;
	}
}
