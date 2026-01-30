import java.util.Arrays;
import java.util.List;
/*
 * Time Complexity:
 *   Build trie: O(sum of lengths of dictionary words)
 *   Replace: for each sentence word of length L, we traverse up to L in trie
 *   => O(total characters in sentence + total characters in dictionary)
 *
 * Space Complexity:
 *   O(total characters in dictionary) for trie nodes
 */

public class ReplaceWords {
    TrieNode root;
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    /*
     * Returns the shortest root in the trie that is a prefix of 'word'.
     * If none exists, returns the original word.
     *
     * Core idea:
     * Walk the trie along the characters of 'word'.
     * - If we ever hit a node with isEnd == true, we found the shortest root.
     * - If the path breaks, no root matches -> return original word.
     */

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for(String word: dictionary) {
            insert(word);
        }
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for ( int i = 0; i < words.length; i++) {
            String word = words[i];
            if(i > 0) sb.append(" ");
            sb.append(getShorterVersionOfTheWord(word));
        }
        return sb.toString();

    }
    private String getShorterVersionOfTheWord(String word) {
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();
        for (char c : word.toCharArray()) {
            // If we already reached the end of a root, stop immediately
            if (curr.isEnd) return prefix.toString();

            int idx = c - 'a';
            // If no further path, word has no root replacement
            if (curr.children[idx] == null) return word;

            curr = curr.children[idx];
            prefix.append(c);
        }

        // Word ended. If current node is end, prefix is a root; else no replacement
        return curr.isEnd ? prefix.toString() : word;
    }

    public static void main(String[] args) {
        ReplaceWords rw = new ReplaceWords();

        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";

        String result = rw.replaceWords(dictionary, sentence);
        System.out.println("Dictionary: " + dictionary);
        System.out.println("Sentence:   " + sentence);
        System.out.println("Result:     " + result);
        // Expected: "the cat was rat by the bat"

        System.out.println(rw.replaceWords(Arrays.asList("a", "aa", "aaa"), "aaaaa aaaa aa a"));
        // Expected: "a a a a" (shortest root always wins)

        System.out.println(rw.replaceWords(Arrays.asList("blue"), "the sky is blueish"));
    }
}
