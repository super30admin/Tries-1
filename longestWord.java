// Time Complexity : O(N*L^2)
// Space Complexity : O(N*L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public String longestWord(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        String result = "";

        for (String word : words) {
            boolean valid = true;

            // Check all prefixes
            for (int i = 1; i < word.length(); i++) {
                if (!wordSet.contains(word.substring(0, i))) {
                    valid = false;
                    break;
                }
            }

            // Update result if word is valid
            if (valid) {
                if (word.length() > result.length() ||
                        (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }

        return result;
    }
}
