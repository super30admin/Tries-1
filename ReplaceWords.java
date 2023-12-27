
// Time complexity : O(m+n)*len
// Space complexity : O(26*len)
import java.util.*;

public class ReplaceWords {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public void insert(String word) {
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
                if (curr.isEnd || curr.children[c - 'a'] == null) {
                    break;
                }
                curr = curr.children[c - 'a'];
                replacement.append(c);
            }
            if (!curr.isEnd) {
                result.append(word);
            } else {
                result.append(replacement.toString());
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}
