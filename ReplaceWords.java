// Time Complexity : O(m*n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> set = new HashSet<>();
        for(String word : dict){
            set.add(word);
        }

        StringBuilder sb = new StringBuilder();

        for(String word : sentence.split(" ")){
            String prefix = "";
            for(int i= 1; i <= word.length(); i++){
                prefix = word.substring(0,i);
                if(set.contains(prefix)){
                    break;
                }
            }

            if(sb.length() > 0){
                sb.append(" ");
            }

            sb.append(prefix);
        }

        return sb.toString();
    }
}
