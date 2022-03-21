// Time Complexity:           O(l)
// Space Complexity:          O(n)
// where l is maximum length of word, n is length of given sentence
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.List;

public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (sb.length() > 0) {
                sb.append(" ");
            }

            String prefixWord = trie.getPrefixWord(word);

            if (prefixWord == null) {
                sb.append(word);
            } else {
                sb.append(prefixWord);
            }
        }
        return sb.toString();
    }
}
