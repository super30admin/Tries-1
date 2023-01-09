// Approach: Create a Trie of all the words in dictionary, iterate over the sentence
// If there is a matching TrieNode with a word, append the new short word to ans
// else append the word in sentence as it is
// Time: O(n) where n is the length of the sentence
// Space: O(n) for size of the Trie

import java.util.*;

class Replace_Words {

    class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public void insert(String word, TrieNode root) {
        TrieNode curr = root;
        for (int i = 0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            insert(word, root);
        }

        StringBuilder ans = new StringBuilder();

        for (String word : sentence.split("\\s+")) {
            if (ans.length() > 0) ans.append(" ");

            TrieNode curr = root;
            for (char letter : word.toCharArray()) {
                if (curr.children[letter - 'a'] == null || curr.word != null)
                    break;
                curr = curr.children[letter - 'a'];
            }
            ans.append(curr.word != null ? curr.word : word);
        }
        return ans.toString();
    }
}
