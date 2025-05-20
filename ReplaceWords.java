import java.util.*
;
public class ReplaceWords {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {

        String[] words = sentence.split("\\s");
        StringBuilder result = new StringBuilder();

        for (String s : dictionary) {
            insert(s);
        }

        for (int i = 0; i < words.length; i++) {
            result.append(getShortedVersion(words[i]));
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public void insert(String s) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
    }

    public String getShortedVersion(String word) {
        StringBuilder sb = new StringBuilder();
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null || curr.isEnd) {
                break;
            }
            sb.append(ch);
            curr = curr.children[ch - 'a'];
        }
        if (curr.isEnd) {
            return sb.toString();
        }
        return word;
    }
}
