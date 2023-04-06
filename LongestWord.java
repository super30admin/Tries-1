/*The time complexity of this implementation is O(nlogn)
* and space complexity is O(n)*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class LongestWord {
    public String longestWord(String[] words) {
        Set<String> validPrefixes = new HashSet<>();
        String longestWord = "";
        Arrays.sort(words);

        for (String word : words) {
            if (word.length() == 1 || validPrefixes.contains(word.substring(0, word.length() - 1))) {
                validPrefixes.add(word);
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
        }

        return longestWord;
    }
    public class Main {
        public static void main(String[] args) {
            String[] words = {"cat", "bat", "rat", "dog", "duck", "ratdog", "catdog", "catduck"};
            LongestWord solution = new LongestWord();
            String longest = solution.longestWord(words);
            System.out.println("The longest word is: " + longest);
        }
    }

}
