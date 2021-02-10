public class Trie {

	private class Node {

		char data;
		Node[] children;
		boolean isTerminal;

		public Node(char data, boolean isTerminal) {
			this.data = data;
			this.isTerminal = isTerminal;
			this.children = new Node[26];
		}

	}

	private Node root;

	// O(1)
	public Trie() {
		this.root = new Node('\0', false);
	}

	// O(word.length)
	public void addWord(String word) {
		Node curr = root;
		for (char ch : word.toCharArray()) {
			Node temp = curr.children[ch - 'a'];
			if (temp == null) {
				temp = new Node(ch, false);
				curr.children[ch - 'a'] = temp;
			}
			curr = temp;
		}
		curr.isTerminal = true;
	}

	// O(word.length)
	public String searchWord(String word, StringBuilder psf) {
		Node curr = root;
		for (char ch : word.toCharArray()) {
			Node temp = curr.children[ch - 'a'];
			psf.append(ch);
			if (temp == null)
				return word;
			else if (temp.isTerminal)
				return psf.toString();
			curr = temp;
		}
		return word;
	}

}

// O(dictionary.length * word[d].length) + O(sentence.length + word[s]*word[s].length)
public String replaceWords(List<String> dictionary, String sentence) {

	StringBuilder ans = new StringBuilder();

	Trie trie = new Trie();
	for (String word : dictionary)
		trie.addWord(word);

	int index = 0;
	int length = sentence.length();

	StringBuilder sb = new StringBuilder();
	while (index < length) {

		char ch = sentence.charAt(index);
		if (ch == ' ') {
			String root = trie.searchWord(sb.toString(), new StringBuilder());
			ans.append(root);
			ans.append(" ");
			sb = new StringBuilder();
			index++;
			continue;
		}
		sb.append(ch);
		index++;
	}

	String root = trie.searchWord(sb.toString(), new StringBuilder());
	ans.append(root);
	return ans.toString();
}