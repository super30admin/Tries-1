// Time Complexity : O(n*L)
// Space Complexity : O(n*L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean end;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.end = true;
    }

    // BFS
    // public String longestWord(String[] words) {
    // TrieNode root = new TrieNode();
    // for (String word : words) { // n*l
    // insert(root, word);
    // }
    // Queue<TrieNode> q = new LinkedList<>();
    // Queue<String> sq = new LinkedList<>();
    // q.add(root);
    // sq.add("");
    // String currStr = "";
    // while (!q.isEmpty()) { // n*l
    // TrieNode curr = q.poll();
    // currStr = sq.poll();
    // for (int i = 25; i >= 0; i--) {
    // TrieNode child = curr.children[i];
    // if (child != null && child.end) {
    // q.add(child);
    // String st = currStr + ((char) ('a' + i));
    // sq.add(st);
    // }
    // }
    // }
    // return currStr;
    // }

    private String maxStr;

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        maxStr = "";
        for (String word : words) {
            insert(root, word);
        }
        dfs(root, new StringBuilder());
        return maxStr;
    }

    private void dfs(TrieNode curr, StringBuilder path) {
        // base
        if (path.length() > maxStr.length()) {
            maxStr = path.toString();
        }
        // logic
        for (int i = 0; i < 26; i++) {
            TrieNode child = curr.children[i];
            if (child != null && child.end) {
                int l = path.length();
                // action
                path.append((char) ('a' + i));
                // recurse
                dfs(child, path);
                // backtrack
                path.setLength(l);
            }
        }
    }
}