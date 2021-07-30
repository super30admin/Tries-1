package problem3;

public class TrieNode {
	private TrieNode[] nodes;
	private boolean isWord;

	public TrieNode() {
		nodes = new TrieNode[26];
		isWord = false;
	}

	public boolean containsKey(char ch) {
		return nodes[ch - 'a'] != null;
	}

	public TrieNode get(char ch) {
		return nodes[ch - 'a'];
	}

	public void put(char ch, TrieNode node) {
		nodes[ch - 'a'] = node;
	}

	public void setWord() {
		isWord = true;
	}

	public boolean isWord() {
		return isWord;
	}
}
