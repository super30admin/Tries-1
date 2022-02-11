// Time Complexity : O(m*n), where m = no of input strings, n = avg length of each word
// But for each function its O(n) where n is length of the input string
// Space Complexity : O(n) where n is length of the input string (it will be n*26)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Trie {

    public class TreeNode {
        TreeNode[] children;
        boolean isEnd;

        TreeNode() {
            children = new TreeNode[26];
            isEnd = false;
        }
    }

    TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr = root;

        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TreeNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }

        return true;
    }
}