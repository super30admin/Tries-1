// Time Complexity : O(NLogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);				// sort the array to eliminate lexicography condition
        
        HashSet<String> word =  new HashSet<>();		// to store unique elements
        String result = "";		// final result set
        
        for(String w : words){		// traverse through all the elements
            if(w.length() == 1 || word.contains(w.substring(0, w.length()-1))){		// if the word length is = 1 or hashset contains the substrings
                if(w.length() > result.length()){			// if we have 2 same length words and since have sorted, first is already stored in the result set
                    result = w;
                }
                
                word.add(w);		// add to the hastset
            }
        }
        
        return result;
    }
}