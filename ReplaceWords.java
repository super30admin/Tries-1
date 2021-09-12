/*
Time: O(Nk) + O(N), k replacements and N words
Space: O(Nk) + O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class ReplaceWords {

    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split("\\s+");
        TrieNode trie = buildTrie(dict);
        return replaceWords(words, trie);
    }

    private String replaceWords(String[] words, TrieNode root) {
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(getShortestReplacement(word, root));
            result.append(" ");
        }
        return result.substring(0, result.length() - 1);
    }

    // core logic starts
    private String getShortestReplacement(String word, final TrieNode root) {
        TrieNode trieNode = root;
        StringBuilder replace = new StringBuilder();
        for (char c : word.toCharArray()) {
            replace.append(c);
            if (trieNode.children[c - 'a'] != null) {
                if (trieNode.children[c - 'a'].isWord) {
                    return replace.toString();
                }
                trieNode = trieNode.children[c - 'a'];
            } else {
                return word;
            }
        }
        return word;
    }
    // core logic ends

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode(' ');
        for (String word : dict) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TrieNode(c);
                }
                temp = temp.children[c - 'a'];
            }
            temp.isWord = true;
        }
        return root;
    }

    public class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

}