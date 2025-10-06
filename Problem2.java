// Time Complexity : O(Nl) where l is the average word length, N is the number of words
// Space Complexity : O(Nl)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Created a trie for all words in the input. Then applying dfs to iterate through the paths to check if the each level of the path for trie is true. If it is true, then we go the next level.
 * Setting the highest length string that has all trie node path values to true. Since we iterate from 0->25 indexes, it will take care of lexicographical condition.
 */
class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }

    String result = "";

    public String longestWord(String[] words) {
        this.root = new TrieNode();
        for (String word : words) {
            insert(word);
        }

        dfs(root, new StringBuilder());
        return result;
    }

    public void dfs(TrieNode node, StringBuilder path) {
        // base
        if (node == null)
            return;

        // logic
        if (path.length() > result.length()) {
            result = path.toString();
        }

        TrieNode[] children = node.children;
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null && children[i].isEnd) {
                path.append((char) ('a' + i));
                dfs(children[i], path);
                path.deleteCharAt(path.length() - 1);
            }
        }

    }

}