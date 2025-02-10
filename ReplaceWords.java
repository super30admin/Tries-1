
/**
 * Time Complexity: O(mk + nl) where m is the number of words in dictionary,
 * k is the average length of word in dictionary,
 * n is the number of words in the given sentence,
 * l is the average length of the word in given sentence.
 * 
 * Space Complexity: O(mk + nl)
 */

import java.util.List;

public class ReplaceWords {

    TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return sentence;
        }

        root = new TrieNode();
        for (String str : dictionary) {
            insert(str);
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i != 0) {
                result.append(" ");
            }
            String word = words[i];
            StringBuilder sb = new StringBuilder();
            TrieNode current = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (current.children[c - 'a'] == null || current.isEnd) {
                    break;
                }
                sb.append(c);
                current = current.children[c - 'a'];
            }
            if (current.isEnd) {
                result.append(sb.toString());
            } else {
                result.append(word);
            }
        }
        return result.toString();
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
        current.isEnd = true;
    }

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

}
