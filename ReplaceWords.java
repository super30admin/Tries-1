import java.util.List;

public class ReplaceWords {
    TrieNode root = new TrieNode();

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String word : dictionary) {
            insert(word);
        }
        String[] strs = sentence.split(" ");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            if (i == strs.length - 1)
                build(word, answer, true);
            else
                build(word, answer, false);
        }
        return answer.toString();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char single = word.charAt(i);
            if (current.children[single - 'a'] == null) {
                current.children[single - 'a'] = new TrieNode();
            }
            current = current.children[single - 'a'];
        }
        current.isEnd = true;
    }

    public void build(String word, StringBuilder answer, boolean isLastWord) {
        TrieNode current = root;
        StringBuilder replacement = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char single = word.charAt(i);

            if (current.children[single - 'a'] == null || current.isEnd) {
                break;
            }
            replacement.append(single);
            current = current.children[single - 'a'];
        }
        if (current.isEnd) {
            if (isLastWord)
                answer.append(replacement);
            else
                answer.append(replacement).append(" ");
        } else {
            if (isLastWord)
                answer.append(word);
            else
                answer.append(word).append(" ");
        }

    }
}
