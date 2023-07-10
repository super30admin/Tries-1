import java.util.List;
import java.util.HashSet;

public class ReplaceWordsHashSet {

        //HASH SET

        public String replaceWords(List<String> dictionary, String sentence) {

            HashSet<String> setDict = new HashSet<>(dictionary); //O(n*l)

            StringBuilder result = new StringBuilder(); // O(m*k) - size

            String[] splitSentence = sentence.split(" ");

            for(int i = 0; i < splitSentence.length; i++) { // O(m*k)

                String currWord = splitSentence[i];

                boolean flag = false;

                if(i > 0) result.append(" ");

                for(int j = 0; j < currWord.length(); j++) {

                    // check for every subword in a word if it is hashset
                    String subWord = currWord.substring(0, j+1);

                    if(setDict.contains(subWord)) {

                        result.append(subWord);

                        flag = true;

                        break;

                    }
                }

                if(!flag) result.append(currWord);
            }

            return result.toString();
        }



}

/*

TIME COMPLEXITY = O(n*l + m*k)

But, averagely time complexity is better if trie is used.

SPACE COMPLEXITY = O(n*l + m*k)

*/