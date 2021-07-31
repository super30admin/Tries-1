package problem3;

public class TrieNode {
	TrieNode[] nodes;
	boolean isWord;

	public TrieNode() {
		nodes = new TrieNode[26];
		isWord = false;
	}
}
