// Time Complexity : O(nk)
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Main {
    // TrieNode class
    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        // constructor TrieNode
        TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    // root TrieNode
    private static TrieNode root;
    private static StringBuilder maxStr;

    // insert word in TrieNode
    private static void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        // make end is true at the end of the word
        curr.isEnd = true;
    }

    // approch 1 DFS BackTrack
    public static String longestWord(String[] words) {
        root = new TrieNode();
        maxStr = new StringBuilder();
        // add all the words in the Trie
        for (String word : words) {
            insert(word);
        }
        // traverse in Trie using backTracking
        // backTrack using dfs
        backTrack(root, new StringBuilder());
        return maxStr.toString();

    }

    private static void backTrack(TrieNode root, StringBuilder curStr) {
        // base case
        if (maxStr.length() < curStr.length()) {
            maxStr = new StringBuilder(curStr);
        }

        // main logic
        // for loop based recursion
        for (int i = 0; i < 26; i++) {
            // get current children at specific index of TriNode array
            TrieNode curr = root.children[i];
            // if current is not null and End is true that means there is word in trie that
            // met condition of the question
            // so we append this character in stringBuilder and also backTrack after
            // recursion
            if (curr != null && curr.isEnd) {
                // action
                curStr.append((char) (i + 'a'));
                // recurese
                backTrack(curr, curStr);
                // backTrack
                curStr.setLength(curStr.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = new String[] { "w", "wo", "wor", "worl", "world" };
        System.out.println(longestWord(words));

    }
}