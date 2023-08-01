package Tries_1;

/**
 * Using a trie to store the given input words and then the search function
 * returns a true only if at each character of the word boolean flag is true.
 * With the search func we determine the longest word that satisfies the
 * criteria.
 * 
 * Time Complexity : O(l*n)- where l is the avg length of the strings given and
 * is the no of words.
 * 
 * Space Complexity : O(L), where L is the length of the largest word present in
 * the dictionary.
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem2 {
	class Trie {

		TrieNode root;

        class TrieNode{
            TrieNode[] letters;
            boolean flag;
            TrieNode(){
                letters= new TrieNode[26];
            }
        }

		void insert(String word) {
			TrieNode curr = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (curr.letters[c - 'a'] == null)
					curr.letters[c - 'a'] = new TrieNode();
				curr = curr.letters[c - 'a'];
			}
			curr.flag = true;
		}

		boolean longestSearch(String word, int maxLen, String maxWord) {
			TrieNode curr = root;
			int count = 0;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				count++;
				if (curr.letters[c - 'a'] != null && curr.letters[c - 'a'].flag)
					curr = curr.letters[c - 'a'];
				else
					break;
			}

			if (count == word.length()) {
				if (count >= maxLen) {
					return true;
				}
			}

			return false;
		}

	}

	public String longestWord(String[] words) {
		int maxLen = 0;
		String maxWord = "";

		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		for (String word : words) {
			if (trie.longestSearch(word, maxLen, maxWord)) {
				if (maxLen == word.length() && word.compareTo(maxWord) < 0) {
					maxLen = word.length();
					maxWord = word;

				} else if (maxLen < word.length()) {
					maxLen = word.length();
					maxWord = word;

				}
			}
		}

		return maxWord;

	}

}
