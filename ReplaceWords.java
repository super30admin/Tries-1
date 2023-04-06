/*The time complexity of this implementation is O(N*L)*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> prefixes = new HashSet<>(dictionary);
        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            for (int i = 1; i <= word.length(); i++) {
                if (prefixes.contains(word.substring(0, i))) {
                    sb.append(word.substring(0, i)).append(" ");
                    break;
                }
                if (i == word.length()) {
                    sb.append(word).append(" ");
                }
            }
        }
        sb.setLength(sb.length() - 1); // remove the trailing space
        return sb.toString();
    }
    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        ReplaceWords sol = new ReplaceWords();
        String result = sol.replaceWords(dictionary, sentence);
        System.out.println(result);
    }
}
