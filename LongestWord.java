import java.util.Arrays;

public class LongestWord {
    // TC: O(NlogN + N * N) where N is length of words
    // SC: O(N) where N is length of words
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        insertIntoTrie(words, root);
        Arrays.sort(words, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return b.length() - a.length();
        });
        for (String w : words) {
            boolean resFound = false;
            for (int i = 0; i < w.length(); i++) {
                if (isWordFound(w, 0, i + 1, root)) {
                    resFound = true;
                } else {
                    resFound = false;
                    break;
                }
            }
            if (resFound) return w;
        }
        return "";
    }

    private void insertIntoTrie(String[] words, TrieNode root) {
        for (String w : words) {
            TrieNode curr = root;
            for (char ch : w.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
            curr.word = w;
        }
    }

    private boolean isWordFound(String w, int start, int end, TrieNode root) {
        TrieNode curr = root;
        for (int i = start; i < end; i++) {
            char ch = w.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
    }
}
class TrieNode {
    boolean isEnd;
    TrieNode[] children;
    String word;
    public TrieNode() {
        this.children = new TrieNode[26];
    }
}
