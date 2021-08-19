//Time complexity: O(n*w), where n is the length of words array and n is the maximum length of a word in words array. 
//Space complexity: O(n*w)

import java.util.*;

class Solution2 {
    public String longestWord(String[] words) {
        HashSet<String> wordsSet = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b) {
                if(a.length() == b.length()) {
                   return a.compareTo(b);
                }
                return b.length() - a.length();  
            }
        }); 
        
        for(String word: words) {
            int i = word.length();
            while(i>=1) {
                if(!wordsSet.contains(word.substring(0, i))) {
                    break;
                }
                i--;
            }
            if(i==0) {
                return word;
            }
        }
        return ""; 
    }
}
