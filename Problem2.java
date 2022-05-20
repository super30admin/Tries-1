import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {

    //Trie Solution
    // TC : O (n + k) - Could you confirm?
    // SC : O (nk)
    // n is word and k is length of word
    private static class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
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
        curr.word = word;
    }

    public String longestWord(String[] words) {
        root = new TrieNode();
        if (words.length == 0) return null;

        for (String word : words) {
            insert(word);
        }
        TrieNode curr = new TrieNode();
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            curr = q.poll();
            for (int i = 25; i >= 0; i--) {
                if (curr.children[i] != null && curr.children[i].word != null) {
                    q.add(curr.children[i]);
                }
            }
        }
        if (curr.word == null) return "";
        return curr.word;

    }
}
