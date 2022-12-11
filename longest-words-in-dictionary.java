
//TC is O(nxl) where n is number of words and l is length of each word
//SC is O(nxl)
import java.util.*;

class Solution {
    TrieNode root;

    public String longestWord(String[] words) {

        if (words == null || words.length == 0)
            return "";
        root = new TrieNode();

        for (String word : words) {
            insert(word);
        }

        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode value = root;

        while (!q.isEmpty()) {

            value = q.poll();

            for (int i = 25; i >= 0; i--) {
                if (value.children[i] != null && value.children[i].str != null) {
                    q.add(value.children[i]);
                }
            }
        }

        if (value.str != null) {
            return value.str;
        } else {
            return "";
        }

    }

    // build our trie
    class TrieNode {
        String str;
        TrieNode[] children;

        public TrieNode() {
            str = null;
            children = new TrieNode[26];

        }
    }

    private void insert(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }

            curr = curr.children[c - 'a'];

        }
        curr.str = word;
    }
}