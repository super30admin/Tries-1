import java.util.*;

public class ReplaceWords {
    // TC: O(N * K) where N is number of words in sentence and K is average length of words
    // SC: O(N) where N is number of words in sentence.
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        TrieNode root = new TrieNode();
        insertIntoTrie(dictionary, root);
        for (String w : words) {
            String rootWord = getRootWord(w, root);
            sb.append(rootWord);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private void insertIntoTrie(List<String> dictionary, TrieNode root) {
        for (String s : dictionary) {
            TrieNode curr = root;
            for (char ch : s.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
            curr.word = s;
        }
    }

    private String getRootWord(String w, TrieNode root) {
        TrieNode curr = root;
        for (char ch : w.toCharArray()) {
            if (curr.children[ch - 'a'] == null) {
                break;
            }
            curr = curr.children[ch - 'a'];
            if (curr.isEnd) return curr.word;
        }
        return w;
    }

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
