import java.util.*;

class TrieNode {
	TrieNode[] children;
	String word;

	public TrieNode() {
		children = new TrieNode[26];
		word = "";
	}
}

public class ReplaceWord {
	TrieNode root = new TrieNode();

	public void insert(String word) {
		TrieNode cur = root;
		int size = word.length();
		for (int i = 0; i < size; i++) {
			int index = word.charAt(i) - 'a';
			if (cur.children[index] == null) {
				cur.children[index] = new TrieNode();
			}
			cur = cur.children[index];
		}
		cur.word = word;
	}

	public String replaceWords(List<String> dict, String sentence) {
		String words[] = sentence.split("\\s");
		for (String word : dict) {
			insert(word);
		}
		StringBuilder ans = new StringBuilder();
		TrieNode cur = root;
		for (String word : words) {
			if (ans.length() > 0) {
				ans.append(" ");
			}
			int size = word.length();
			for (int i = 0; i < size; i++) {
				int index = word.charAt(i) - 'a';
				if (cur.children[index] == null || cur.word != null)
					break;
				cur = cur.children[index];
			}
			ans.append(cur.word != null ? cur.word : word);
		}
		return ans.toString();
	}

	public static void main(String []args) {
		ArrayList<String> dict = new ArrayList<String>(Arrays.asList("cat", "bat", "rat"));
		String sentence = "the cattle was rattled by the battery";

		ReplaceWord word = new ReplaceWord();
		System.out.print(word.replaceWords(dict, sentence));
	}
}
	