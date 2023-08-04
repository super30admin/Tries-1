package org.example;
// Time Complexity : O(m*l)  ->m is the number of words  & l is the length of each word
// Space Complexity : O(m*l)
// Did this code successfully run on Leetcode : Yes
import java.util.HashSet;
import java.util.List;

public class ReplaceWordsUsingHashSet {
    public String replaceWords(List<String> dictionary, String sentence) {

        HashSet set = new HashSet<>(dictionary);
        StringBuilder result = new StringBuilder();

        String[] splittedSentence = sentence.split(" ");

        for(int i=0; i<splittedSentence.length; i++)
        {
            if(i>0) result.append(" ");
            String word = splittedSentence[i];
            boolean flag = false;
            for(int j=0; j<word.length();j++)
            {
                String subString = word.substring(0,j+1);
                if(set.contains(subString))
                {
                    result.append(subString);
                    flag = true;
                    break;
                }
            }
            if(!flag) result.append(word);
        }
        return result.toString();
    }
}
