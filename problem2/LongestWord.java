//Time Complexity : O(sum(length of each word)^2)
// Space Complexity : O(sum(length of each word)^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWord {
	/********************* Brute Force *********************/
	public String longestWord(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}
		Set<String> set = new HashSet<String>();
		for (String word : words) {
			set.add(word);
		}

		Arrays.sort(words, (word1, word2) -> word1.length() == word2.length() ? word1.compareTo(word2)
				: word2.length() - word1.length());

		for (String word : words) {
			boolean good = true;
			for (int i = 1; i < word.length(); i++) {
				if (!set.contains(word.substring(0, i))) {
					good = false;
					break;
				}
			}
			if (good) {
				return word;
			}
		}
		return "";
	}

	public static void main(String[] args) {
		LongestWord obj = new LongestWord();
		String[] words = { "w", "wo", "wor", "worl", "world" };
		System.out.println("Longest word: " + obj.longestWord(words));
	}

}
