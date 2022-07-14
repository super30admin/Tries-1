// Time Complexity : O(nxl) - n is the number of words in the array, l - length of the words
// Space Complexity : O(l) - stack space for length of the word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//720. Longest Word in Dictionary
//https://leetcode.com/problems/longest-word-in-dictionary/

class Solution {
    // time: O(nxl) - n is the number of words in the array, l - length of the words
    // space: O(l)
    class Trie {

        class TrieNode {
            boolean isEnd;
            TrieNode[] children;

            public TrieNode() {
                // this.isEnd = false;
                children = new TrieNode[26];
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                if (curr.children[word.charAt(i) - 'a'] == null)
                    curr.children[word.charAt(i) - 'a'] = new TrieNode();
                curr = curr.children[word.charAt(i) - 'a']; // how to go to the node it is pointing to
            }
            curr.isEnd = true; // System.out.println("word " + word);
        }

        public boolean search(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                if (curr.children[word.charAt(i) - 'a'] == null)
                    return false;
                curr = curr.children[word.charAt(i) - 'a']; // how to go to the node it is pointing to
            }
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (curr.children[prefix.charAt(i) - 'a'] == null)
                    return false;
                curr = curr.children[prefix.charAt(i) - 'a']; // how to go to the node it is pointing to
            }
            return true;
        }

        public TrieNode getTrieRoot() {
            return root;
        }

    }

    public String longestWord(String[] words) {

        Trie t = new Trie();

        for (int i = 0; i < words.length; i++) {
            t.insert(words[i]); // System.out.println(dictionary.get(i));
        }

        Trie.TrieNode root = t.getTrieRoot();

        dfs(root);

        return maxString.toString();

    }

    StringBuilder sb = new StringBuilder();
    StringBuilder maxString = new StringBuilder();

    Trie tr = new Trie();
    Trie.TrieNode curr = tr.getTrieRoot();

    private void dfs(Trie.TrieNode root) {
        // base

        // logic
        curr = root;
        for (int i = 122; i >= 97; i--) { // System.out.println("i " + i);

            if (curr.children[i - 'a'] != null && curr.children[i - 'a'].isEnd == true) {
                // if length is larger than or equal to current count size, add it to the
                // resultant string after removing previous added strings of lesser length
                sb.append(Character.toString(i)); // System.out.println("sbbbbb " + sb);

                if (sb.length() >= maxString.length()) {
                    maxString = new StringBuilder(); // System.out.println("BEFORE backtracking maxString " +
                                                     // maxString); System.out.println("BEFORE backtracking sb " + sb);
                    maxString.append(sb);
                }
                Trie.TrieNode temp = curr;

                // do dfs
                dfs(curr.children[i - 'a']);

                // backtrack
                sb.deleteCharAt(sb.length() - 1); // System.out.println("after backtracking maxString " + maxString);
                                                  // System.out.println("after backtracking sb " + sb);
                curr = temp;
            }

        }

    }

}
