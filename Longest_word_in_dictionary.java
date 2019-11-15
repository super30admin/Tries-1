TC: O(n)
SC: O(n)

Runtime: 16 ms, faster than 37.59% of Java online submissions for Longest Word in Dictionary.
Memory Usage: 38.2 MB, less than 81.25% of Java online submissions for Longest Word in Dictionary.




class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<String>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }
}
