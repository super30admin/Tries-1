/**
 * Time Complexity: O(m * k), where m is the number of words and k is the
 * average length of each word.
 * Space Complexity: O(m * k)
 */

class LongestWord {

    TrieNode root;
    String result = "";

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }
        search(root);
        return result;
    }

    private void search(TrieNode current) {
        if (current.word.length() > result.length()) {
            result = current.word;
        }
        for (int i = 0; i < 26; i++) {
            if (current.children[i] != null && current.children[i].word != "") {
                search(current.children[i]);
            }
        }
    }

    private void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode();
            }
            current = current.children[ch - 'a'];
        }
        current.word = word;
    }

    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            word = "";
        }
    }
}