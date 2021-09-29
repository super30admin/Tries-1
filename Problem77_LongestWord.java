// Time Complexity : O(s), where s = sum of all words 
// Space Complexity : O(s)
// Did this code successfully run on Leetcode : Yes

class TrieNode {
	TrieNode[] children = new TrieNode[26];
	String word;
	TrieNode () {
        this.children = new TrieNode[26];
    }
}

class Solution {
	private TrieNode root;
	private String result = "";

	public String longestWord(String[] words) {
		root = new TrieNode();
		for (String w : words)
			insert(w);
		dfs(root);
		return result;
	}

	private void dfs(TrieNode node) {
		if (node == null)
			return;
		if (node.word != null) {
			if (node.word.length() > result.length())
				result = node.word;
			else if (node.word.length() == result.length() && node.word.compareTo(result) < 0)
				result = node.word;
		}
		for (TrieNode child : node.children)
			if (child != null && child.word != null)
				dfs(child);
	}

	private void insert(String word) {
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			if (current.children[c - 'a'] == null)
				current.children[c - 'a'] = new TrieNode();
			current = current.children[c - 'a'];
		}
		current.word = word;
	}

}