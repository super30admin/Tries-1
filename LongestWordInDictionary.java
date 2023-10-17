import java.util.Queue;

public class LongestWordInDictionary {
    class TrieNode {
        String word;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(word, root);
        }
        Queue<TrieNode> q = new java.util.LinkedList<>();
        q.add(root);
        TrieNode curr = new TrieNode();
        while (!q.isEmpty()) {
            curr = q.poll();
            for (int index = 25; index >= 0; index--) {
                TrieNode child = curr.children[index];
                if (child != null && child.word != null) {
                    q.add(child);
                }
            }
        }
        if (curr.word == null)
            return "";
        return curr.word;
    }

    public void insert(String word, TrieNode root) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char single = word.charAt(i);
            if (current.children[single - 'a'] == null) {
                current.children[single - 'a'] = new TrieNode();
            }
            current = current.children[single - 'a'];
        }
        current.word = word;
    }
}
