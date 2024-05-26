import java.util.HashSet;
import java.util.List;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary); //nl +mk^2  n-> total number of words in dict l-> avg length of words in dict
        //k -> avg length of each word in sentence
        String[] strArr = sentence.split(" ");

        StringBuilder result = new StringBuilder();
        for(int i=0; i< strArr.length; i++)  //mk^2
        {
            String word = strArr[i];
            if(i > 0) result.append(" ");
            boolean flag = false;

            for(int k =0; k<word.length(); k++)  //k
            {
                String sub = word.substring(0, k+1); //k
                if(set.contains(sub))
                {
                    flag = true;
                    result.append(sub);
                    break;
                }
            }

            if(!flag)
            {
                result.append(word);
            }
        }
        return result.toString();
    }
}
