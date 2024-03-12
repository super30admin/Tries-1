//Accepted on LT
// Same logic maintain a trie and in the trie we chekc for any word to replace if so we do
class Solution {
    class TrieNode {
        boolean flag;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();

        for (String word : dictionary) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                }
                current = current.children[c - 'a'];
            }
            current.flag = true;
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            TrieNode current = root;
            StringBuilder prefix = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (current.children[c - 'a'] == null) break;
                prefix.append(c);
                current = current.children[c - 'a'];
                if (current.flag) {
                    word = prefix.toString();
                    break;
                }
            }
            if (result.length() > 0) result.append(" ");
            result.append(word);
        }

        return result.toString();
    }
}
