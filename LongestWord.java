// Time Complexity :O(N*l);
// Space Complexity :O(N*l);
public class LongestWord {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; 
    }

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new TrieNode();
                }
                cur = cur.children[idx];
            }
            cur.word = word; 
        }

        return dfs(root, "");
    }

    private String dfs(TrieNode node, String result) {
        String longest = result;

        for (TrieNode child : node.children) {
            if (child != null && child.word != null) {
                String candidate = dfs(child, child.word);
                if (candidate.length() > longest.length() ||
                    (candidate.length() == longest.length() && candidate.compareTo(longest) < 0)) {
                    longest = candidate;
                }
            }
        }

        return longest;
    }
}
