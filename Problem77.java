class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);  // Sort words lexicographically
        Set<String> wordSet = new HashSet<>();
        wordSet.add("");  // Initialize with empty string
        String longestWord = "";

        for (String word : words) {
            // Check if the prefix (all characters except the last one) exists in the set
            if (wordSet.contains(word.substring(0, word.length() - 1))) {
                wordSet.add(word);  // Add the current word to the set
                // Update the longest word if necessary
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
        }

        return longestWord;
    }
}
