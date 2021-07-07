// Time Complexity : O(m*n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
        public String longestWord(String[] words) {
            String ans = "";
            Set<String> set = new HashSet<>();
            for(String word : words){
                set.add(word);
            }
            for(String word : words){
                if(word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)){
                    boolean isCorrect = true;
                    for(int k = 1; k < word.length(); k++){
                        if(!set.contains(word.substring(0,k))){
                            isCorrect = false;
                            break;
                        }
                    }

                    if(isCorrect) {
                        ans = word;
                    }
                }
            }

            return ans;
        }
}

