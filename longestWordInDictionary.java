// Time Complexity = O(n*l), where n is the no. of words and l is the avg length of each word
// Space Complexity = O(n*l)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Every time we have a word in the input words list, we mark the word value in TrieNode with the word,
// this will help us in identifying if we have the continuous substring till that point, we add only those elements to
// the queue that are having non null word value
class Solution {
    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }

    public String longestWord(String[] words) {
        if(words == null || words.length == 0) return "";
        root = new TrieNode();

        // update the trie
        for (String word: words) {
            insert(word);
        }

        // BFS
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = root;

        while (!q.isEmpty()) {
            curr = q.poll();

            // traversing from the back lexicographically since the last element in curr will be the one that we can return
            for (int i=25; i>=0; i--) {
                if (curr.children[i] != null && curr.children[i].word != null) {
                    q.add(curr.children[i]);
                }
            }
        }

        if(curr.word == null) return "";
        return curr.word;
    }
}