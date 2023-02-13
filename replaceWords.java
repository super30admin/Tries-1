// Time Complexity : O(ml + nl)n words in dictionary, m is the no of words in sentance. l represents the length.
// Space Complexity : O(ml + nl)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * insert all words from the idctionary in the trienode
 * split the sentence into words and search for the shortest word in the trienode and return the string after replacemnt.
*/
class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }

            current = current.children[c - 'a'];
        }

        current.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();

        // iterate over dictionary
        for (String word : dictionary) // O(nl), n is the no of words in dictionary and l is the length
        {
            insert(word);
        }

        String[] splitArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : splitArr) // O(ml), m is the no of words in the sentence and l is the avg length.
        {
            StringBuilder replace = new StringBuilder();
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (current.isEnd || current.children[c - 'a'] == null) {
                    break;
                }

                replace.append(c);
                current = current.children[c - 'a'];
            }
            if (current.isEnd) {
                result.append(replace);
            } else {
                result.append(word);
            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}