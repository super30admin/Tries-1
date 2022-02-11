import java.util.List;

public class ReplaceWords {

    // Time Complexity: O(N) where N is the length of the sentence. Every query of a
    // word is in linear time.
    // Space Complexity: O(N), the size of our trie.
    class TrieNode {
        boolean end;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.end = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for (String dict : dictionary) {
            insert(dict);
        }
        String[] splitword = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < splitword.length; i++) {
            if (i > 0) {
                res.append(" ");
            }
            StringBuilder rep = new StringBuilder();
            TrieNode curr = root;
            String word = splitword[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (curr.children[c - 'a'] == null || curr.end) {
                    break;
                }
                rep.append(c);
                curr = curr.children[c - 'a'];
            }
            if (curr.end) {
                res.append(rep);
            } else {
                res.append(word);
            }
        }
        return res.toString();
    }
}
