import java.util.List;


/*
 * TC : O(N*K +L) where N is the number of words in dictionary and K is the maximum length.
 *      So. NK is time needed to create dictionary and L is the length of the string given.
 *       As we iterate over the string, L is the time needed for the same. Therefore the time complexity will be dominated by the one of the two terms.
 *
 * SC : it will be O(26^k) for creating a dictionary of N words where k is the maximum length of the word.
 */
public class ReplaceWords {

    class TrieNode {

        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }

        curr.isEnd = true;

    }

    /**
     * Here we iterate over the words of the String one by one and for each word, if we find a prefix then we replace it with smallest prefix
     * else we keep the word as it is.
     *
     * @param dictionary
     * @param sentence
     * @return
     */

    public String replaceWords(List<String> dictionary, String sentence) {

        root = new TrieNode();

        for (String word : dictionary) {
            insert(word);
        }

        String[] splitArr = sentence.split("\\s+");
        StringBuilder replacement = new StringBuilder();
        for (int k = 0; k < splitArr.length; k++) {
            String s = splitArr[k];
            if (k > 0)
                replacement.append(" ");
            StringBuilder replaceWord = new StringBuilder();
            char[] s_char = s.toCharArray();
            TrieNode curr = root;
            for (char c : s_char) {

                if (curr.children[c - 'a'] == null || curr.isEnd)
                    break;

                if (curr.children[c - 'a'] != null) {

                    replaceWord.append(c);

                    curr = curr.children[c - 'a'];

                }
            }
            if (curr.isEnd) {

                replacement.append(replaceWord);

            } else {

                replacement.append(s);

            }
        }

        return replacement.toString();

    }
}
