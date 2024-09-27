// Time Complexity: O(nlogn)
// Space COmplexity: O(no of words)
class Solution {
    public String longestWord(String[] words) {
        if(words == null || words.length == 0) {
            return "";
        }
        Arrays.sort(words);

        String res = "";
        HashSet<String> set = new HashSet<>();

        for(String word: words) {
            if(word.length() == 1 || set.contains(word.substring(0, word.length()-1))) {
                if(word.length() > res.length()) {
                    res = word;
                }
                set.add(word);
            }
        }
        return res;
    }
}