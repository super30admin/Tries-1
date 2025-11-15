import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * LeetCode Problem 720: Longest Word in Dictionary
 * https://leetcode.com/problems/longest-word-in-dictionary/
 * Time Complexity: O(N * log N) due to sorting the words array.
 * Time Complexity: O(N * M) where N is the number of words and M is the average
 * length of the words.
 */
public class LongestWord {

    public String longestWord(String[] words) {
      Set<String> insertedPrefixes = new HashSet<>();
        Set<String> results = new HashSet<>();
        Arrays.sort(words);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            insertedPrefixes.add(word);
            if (word.length() > 1) {
                String prefix = word.substring(0, word.length() - 1);
                if (!insertedPrefixes.contains(prefix)) {
                    insertedPrefixes.remove(word);
                } else {
                    results.remove(prefix);
                    results.add(word);
                }
            } else {
                results.add(word);
                insertedPrefixes.add(word);
            }
        }
        return results.stream()
                .max((a, b) -> {
                    if (a.length() != b.length()) {
                        return a.length() - b.length();
                    } else {
                        return b.compareTo(a);
                    }
                })
                .orElse("");
    }

    public static void main(String[] args) {
        String[] words = { "w", "wo", "wor", "worl", "world" };
        String longest = new LongestWord().longestWord(words);
        System.out.println(longest);

        words = new String[] { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        longest = new LongestWord().longestWord(words);
        System.out.println(longest);

        words = new String[] { "a", "ar", "arj", "aru", "arun", "arju", "arjun" };
        longest = new LongestWord().longestWord(words);
        System.out.println(longest);

        words = new String[] { "m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat" };
        longest = new LongestWord().longestWord(words);
        System.out.println(longest);

        words = new String[] { "yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz",
                "y" };
        longest = new LongestWord().longestWord(words);
        System.out.println(longest);
    }
}
