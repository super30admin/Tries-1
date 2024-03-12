// Time Complexity : O(n * W) [w: number of characters in each word; n: number of words in the array; W: ∑(w)]
// Space Complexity : O(n * W)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    String result = "";

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode parent;

        public Trie() {
            this.parent = new TrieNode();
        }

        public void insert(String word) {
            char a = 'a';
            TrieNode curr = this.parent;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (null == curr.children[ch - a]) {
                    curr.children[ch - a] = new TrieNode();
                }

                curr = curr.children[ch - a];
            }

            curr.isEnd = true;
        }
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();

        for (String str : words) {
            trie.insert(str);
        }

        dfs(trie.parent, new StringBuilder());
        return result;

        // // result = helperDfs(trie.parent, new StringBuilder(), trie.parent);
        // // return result.substring(0, result.length() - 1);

        // return helperBfs(trie.parent);

    }

    private String helperBfs(TrieNode parent) {
        Queue<TrieNode> q = new LinkedList<>();
        q.offer(parent);
        Queue<String> sq = new LinkedList<>();
        sq.offer("");

        TrieNode curr = null;
        String currString = "";
        while (!q.isEmpty()) {
            curr = q.poll();
            currString = sq.poll();
            for (int i = 25; i >= 0; i--) {
                if (curr.children[i] != null && curr.children[i].isEnd) {
                    q.offer(curr.children[i]);
                    char currch = (char) ('a' + i);
                    sq.offer(currString + currch);
                }
            }
        }

        return currString;
    }

    private String helperDfs(TrieNode parent, StringBuilder path, TrieNode child) {

        // base
        if (child != parent) {
            if (child == null || !child.isEnd) {
                return path.toString();
            }
        }

        // logic
        String max = "";
        for (int i = 0; i < 26; i++) {
            // action
            char currCh = (char) ('a' + i);
            path.append(currCh);
            // recurse
            String inter = helperDfs(parent, path, child.children[i]);
            if (inter.length() > max.length()) {
                max = inter;
            }
            // backtrack
            path.deleteCharAt(path.length() - 1);
        }
        return max;
    }

    private void dfs(TrieNode parent, StringBuilder sb) {
        // base
        if (parent.isEnd && sb.length() > result.length()) {
            result = sb.toString();
        }

        // logic
        for (int i = 0; i < 26; i++) {
            if (parent.children[i] != null && parent.children[i].isEnd) {
                // action
                char currCh = (char) ('a' + i);
                sb.append(currCh);
                // recurse
                dfs(parent.children[i], sb);
                // backtrack
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}