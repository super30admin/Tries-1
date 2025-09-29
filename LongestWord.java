//Time Complexity: O(n) - for inserting the words
//Space Complexity: O(max(l)) - max length of the output word
import java.util.Arrays;

public class LongestWord {

    private class TrieNode {
        private boolean end;
        private final TrieNode[] children;

        private TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private final TrieNode root;
    private String output;

    public LongestWord() {
        this.root = new TrieNode();
        this.output = "";
    }

    public String longestWord(String[] words) {
        Arrays.stream(words).forEach(this::insert);
        final StringBuilder builder = new StringBuilder();
        dfs(root, builder);

        return output;
    }

    private void dfs(TrieNode current, StringBuilder builder) {
        if (builder.length() > output.length()) {
            output = builder.toString();
        }

        for (char c = 'a'; c <= 'z'; c++) {
            int index = c - 'a';
            TrieNode node = current.children[index];
            if (node != null && node.end) {
                builder.append(c);
                dfs(node, builder);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

    private void insert(String word) {
        TrieNode current = root;

        for (char ch: word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.end = true;
    }

    public static void main(String[] args) {

        System.out.println(new LongestWord().longestWord(new String[] {"w", "wor", "wo", "worl", "world"}));
        System.out.println(new LongestWord().longestWord(new String[] {"a", "apple", "app", "ap", "apply", "appl", "banana"}));
    }
}
