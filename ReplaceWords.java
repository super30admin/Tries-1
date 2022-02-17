//  Time Complexity: O(n)
//  Space Complexity: O(n)

import java.util.*;

public class ReplaceWords {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void trieInsert(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }

            cur = cur.children[c - 'a'];
        }

        cur.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        StringBuilder result = new StringBuilder();

        for (String word : dictionary) {
            trieInsert(word);
        }

        String[] ar = sentence.split(" ");

        for (String str : ar) {
            StringBuilder replacement = new StringBuilder();
            TrieNode cur = root;

            for (char c : str.toCharArray()) {
                if (cur.children[c - 'a'] == null || cur.isEnd) {
                    break;
                }

                replacement.append(c);
                cur = cur.children[c - 'a'];
            }

            if (cur.isEnd) {
                result.append(replacement);
            }
            else {
                result.append(str);
            }

            result.append(" ");
        }

        return result.toString().trim();
    }
}
