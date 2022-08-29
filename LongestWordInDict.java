// Time Complexity : O(n*m) // n is the length of the array and m is the avg length of the word. 
// Space Complexity : O(n*m) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

import java.util.*;

class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        char ch;

        public TrieNode() {
            // given-only lower case letters
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
            curr.ch = ch;
        }
        curr.isEnd = true;
    }

    // dfs
    String result;

    public String longestWord(String[] words) {
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }
        result = "";
        dfs(root, new StringBuilder());
        return result;
    }

    private void dfs(TrieNode root, StringBuilder path) {
        // base
        if (result.length() < path.toString().length()) {
            result = path.toString();
        }
        // logic
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].isEnd) {
                // action
                path.append(root.children[i].ch);
                // recurse
                dfs(root.children[i], path);
                // backtrack
                path.setLength(path.toString().length() - 1);
            }
        }
    }
}