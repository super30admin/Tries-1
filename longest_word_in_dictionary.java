// Time Complexity : O(n * l) where n is number of words and l is average word length
// Space Complexity : O(26 * n * l) in the worst case for storing Trie nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We first insert all words into a Trie so that every word and prefix can be checked efficiently.
// For each word, we traverse the Trie and make sure every character we visit ends a valid word, meaning the word can be built one character at a time.
// We update the answer when we find a longer valid word, or when the word has the same length but is lexicographically smaller.

class Solution {
    class TrieNode {
        TrieNode [] children;
        boolean isEnd;
        
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    public void insert(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }

    public String longestWord(String[] words) {
        this.root = new TrieNode();
        for (String word: words) {
            insert(word);
        }

        String result = "";
        for (String word: words) {
            if (canBuild(word)) {
                if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result)<0)) {
                    result = word;
                }
            }
        }
        return result;
    }

    private boolean canBuild(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);

            if (curr.children[ch-'a'] == null) return false;
            curr = curr.children[ch-'a'];

            if (!curr.isEnd) return false;
        }
        return true;
    }
}