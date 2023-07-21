import java.util.List;
import java.util.ArrayList;

public class ReplaceWords {
    class TrieNode {
        private boolean isEnd;
        private TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
            // isEnd = false;
        }

        public String replaceWords(List<String> dictionary, String sentence) {
            return null;
        }
    }

    private TrieNode root;

    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for (String word : dictionary) {
            insert(word);
        }

        String[] strArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < strArr.length; k++) {
            String word = strArr[k];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.isEnd || curr.children[c - 'a'] == null)
                    break;
                curr = curr.children[c - 'a'];
                replacement.append(c);
            }
            result.append(" ");
            if (!curr.isEnd) {
                result.append(word);
            } else {
                result.append(replacement.toString());
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();

        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");

        String sentence = "the cattle was rattled by the battery";

        String replacedSentence = replaceWords.replaceWords(dictionary, sentence);
        System.out.println(replacedSentence);
    }

}
