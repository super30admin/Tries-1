//brute force


public class LongestWord {
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

}