import java.util.LinkedList;
import java.util.Queue;

public class LongestWordInDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(root, word);
        }

        Queue<TrieNode> q = new LinkedList<>();
        Queue<String> sq = new LinkedList<>();
        q.add(root);
        sq.add("");
        String currStr = "";

        while (!q.isEmpty()) {
            TrieNode curr = q.poll();
            currStr = sq.poll();
            for (int i = 25; i >= 0; i--) {
                TrieNode child = curr.children[i];
                if (child != null && child.isEnd) {
                    q.add(child);
                    String st = currStr + ((char) ('a' + i));
                    sq.add(st);
                }
            }
        }
        return currStr;
    }

    public static void main(String[] args) {
        LongestWordInDictionary trie = new LongestWordInDictionary();

        // String[] words = { "w", "wo", "wor", "worl", "world" };
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        String longestWord = trie.longestWord(words);
        System.out.println("Longest word in the dictionary: " + longestWord);
    }
}