// Time complexity - O(n)
//Space Complexity -O(n)
// Solved on leetcode - yes
// faced any issues - No
// We first store all words in a set for quick prefix lookup. Then, for each word, we check if all its prefixes exist in the set to ensure it can be built one character at a time. While doing this, we keep track of the longest word that satisfies the condition, breaking ties by lexicographical order.
class Solution {
    public String longestWord(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        String result = "";

        for (String word : words) {
            if (isBuildable(word, wordSet)) {
                if (word.length() > result.length() || 
                    (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }

    private boolean isBuildable(String word, Set<String> wordSet) {
        for (int i = 1; i < word.length(); i++) {
            if (!wordSet.contains(word.substring(0, i))) {
                return false;
            }
        }
        return true;
    }
}
