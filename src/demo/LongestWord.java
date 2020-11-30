package demo;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> set = new HashSet();
        for (String word: words) set.add(word);
        for (String word: words) {
            if (word.length() > ans.length() ||
                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean flag = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!set.contains(word.substring(0, k))) {
                        flag = false;
                        // break;
                    }
                }
                if (flag == true) ans = word;
            }    
        }
        return ans;
    
    }
}