//  Time Complexity: O(Sum of length of words)
//  Space Complexity: O(Sum of length of words)

public class LongestWordInDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        char ch;

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
            cur.ch = c;
        }

        cur.isEnd = true;
    }

    String result;

    public String longestWord(String[] words) {
        root = new TrieNode();
        result = "";

        for (String word : words) {
            trieInsert(word);
        }

        dfs(root, new StringBuilder());

        return result;
    }

    private void dfs(TrieNode cur, StringBuilder sb) {
        //  path
        if (sb.length() >= result.length()) {
            result = sb.toString();
        }

        //  logic
        for (int i = 25; i >= 0; --i) {
            if (cur.children[i] != null && cur.children[i].isEnd) {
                sb.append(cur.children[i].ch);
                dfs(cur.children[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
