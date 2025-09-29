import java.util.List;

public class ReplaceWords {

    private class TrieNode {
        private boolean end;
        private final TrieNode[] children;

        private TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private final TrieNode root;

    public ReplaceWords() {
        this.root = new TrieNode();
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.forEach(this::insert);

        final StringBuilder builder = new StringBuilder();
        final String[] array = sentence.split(" ");

        for (int i = 0; i < array.length; i++) {
            final String shorter = prefix(array[i]);
            builder.append(shorter);

            if (i != array.length - 1) builder.append(" ");
        }

        return builder.toString();
    }

    private void insert(final String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];

            if (current.end) break; //to not insert a word if there exists a shorter word
        }

        current.end = true;
    }

    private String prefix(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) return word;

            current = current.children[index];
            if (current.end) return word.substring(0, i + 1);
        }

        return word;
    }
}
