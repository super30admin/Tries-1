import java.util.*;

class Solution {
    // Hash Set Solution
    // Time complexity is O(m*l) + O(n*k) 
    // O(m*l) is for creating trie
    // O(n*k) is for search where k is the average length
    // Space complexity is O(n*L) where n is the number of words and L is the length
    // Let me know if space complexity is correct
    public String replaceWords(List<String> dictionary, String sentence) {
        // Edge case
        if(sentence == null || sentence.length()==0) return sentence;
        StringBuilder result = new StringBuilder();
        // Build and create hashset
        HashSet<String> set = new HashSet<>(dictionary);
        String [] splited = sentence.split(" ");
        
        // Let's find
        for(int i = 0; i<splited.length; i++){
            if(i>0) result.append(" ");
            String findWord = splited[i];
            int prevLength = result.length();
            for(int j = 0; j<findWord.length(); j++){
                String subWord = findWord.substring(0,j+1);
                if(set.contains(subWord)){
                    result.append(subWord);
                    break;
                }
            }
            if(prevLength == result.length())
                result.append(findWord);
        }
        
        return result.toString();
    }
}