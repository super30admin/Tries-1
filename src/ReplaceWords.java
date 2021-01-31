import java.util.List;

/*
 * Time Complexity of the algorithm is O(m*n) where m is no of words and n is max length per word
 * space Complexity will O(m*n) where m and n are no of words in both string
 */

public class ReplaceWords {

	class TrieNode {

		boolean isEnd;
		TrieNode[] children;

		public TrieNode() {

			children = new TrieNode[26];
		}
	}

	TrieNode root;

	private void insert(String word) {

		TrieNode curr = root;
		// System.out.println("insert");

		for (int i = 0; i < word.length(); i++) {

			char c = word.charAt(i);
//System.out.println("insert1");
			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new TrieNode();
			}

			curr = curr.children[c - 'a'];
		}

		curr.isEnd = true;

	}

	public String replaceWords(List<String> dictionary, String sentence) {

		root = new TrieNode();
		// System.out.println("replaceWords");
		for (String word : dictionary) {
//System.out.println("replaceWords1");
			insert(word);

		}

		String[] strArray = sentence.split("\\s+");

		StringBuilder result = new StringBuilder();
		TrieNode curr;
		StringBuilder replacement;

		for (int k = 0; k < strArray.length; k++) {

			if (k > 0) {
				result.append(" ");
			}

			String s = strArray[k];
			curr = root;
			replacement = new StringBuilder();

			for (int i = 0; i < s.length(); i++) {

				char c = s.charAt(i);

				if (curr.children[c - 'a'] == null || curr.isEnd) {

					break;
				}

				replacement.append(c);
				curr = curr.children[c - 'a'];
			}

			if (curr.isEnd) {

				result.append(replacement);
			} else {
				result.append(s);
			}

		}

		return result.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
