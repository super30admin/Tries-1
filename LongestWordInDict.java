// Time Complexity : O(wordLength^2)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> set = new HashSet();
        for (String word: words){
            set.add(word);
        }
        for (String word: words) {
            if (word.length() > ans.length() ||
                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean flag = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!set.contains(word.substring(0, k))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) ans = word;
            }    
        }
        return ans;
    }
}