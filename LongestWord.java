// Problem 720. Longest Word in Dictionary
// Time Complexity : O(N*L)
// Space Complexity : O(N*L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class LongestWord {
    tatic class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word;
    }
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(root, word);
        }
        String longest = "";
        Stack<TrieNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TrieNode node = stack.pop();
            for (TrieNode child : node.children) {
                if (child != null && child.word != null) {
                    stack.push(child);
                    if (child.word.length() > longest.length() ||
                            (child.word.length() == longest.length() && child.word.compareTo(longest) < 0)) {
                        longest = child.word;
                    }
                }
            }
        }
        return longest;
    }
}
