// Time Complexity : Insert -  O(nl), n is the number of words and l is the average length of the word
// Space Complexity : O(nl)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/* DFS
 * create a trienode array to store the characters for the words inserted and isEnd boolean to store the end point of the word. isEnd -> true means it is the end of charcter of thw word inserted
 * Use bracktracking to find the word
*/
class Solution {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
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
        curr.isEnd = true;
    }

    String result;

    public String longestWord(String[] words) {
        result = "";
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }
        backtrack(root, new StringBuilder());

        return result;
    }

    private void backtrack(TrieNode root, StringBuilder curr) {
        // base
        if (curr.length() > result.length())
            result = curr.toString();
        // logic
        for (int i = 0; i < 26; i++) {
            TrieNode child = root.children[i];
            if (child != null && child.isEnd) {
                int le = curr.length();
                // action
                curr.append((char) ('a' + i));
                // recurse
                backtrack(child, curr);
                // backtrack
                curr.setLength(le);
            }
        }
    }
}

// BFS

// Time Complexity : Insert - O(nl), n is the number of words and l is the
// average length of the word
// Space Complexity : O(nl)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * BFS approach
 */
class Solution {

    TrieNode root;

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        String word;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.word = "";
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
        curr.isEnd = true;
        curr.word = word;
    }

    public String longestWord(String[] words) {
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }

        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);

        TrieNode curr = null;
        while (!q.isEmpty()) {
            curr = q.poll();
            for (int i = 25; i >= 0; i--) {
                if (curr.children[i] != null && curr.children[i].isEnd) {
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}