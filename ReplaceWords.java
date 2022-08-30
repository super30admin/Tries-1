// Time Complexity : O(n*m + l*k) // n is the length of the list and m is the avg length of each word, l is the no of words in the sentence and k is the avg length of each word
// Space Complexity : O(n*m) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

import java.util.*;

class Solution {
    class TrieNode {
        boolean end;
        TrieNode[] children;

        public TrieNode() {
            // given-only lower case letters
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    Solution() {
        root = new TrieNode();
    }

    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.end = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        // add the dictionary to the Tries
        for (String word : dictionary) {
            insert(word);
        }
        // split the sentence
        String[] splitArray = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : splitArray) {
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            // traverse through each character in the word and check if it exists in Trie.
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.children[ch - 'a'] == null || curr.end == true)
                    break;
                curr = curr.children[ch - 'a'];
                replacement.append(ch);
            }
            if (curr.end)
                result.append(replacement);
            else
                result.append(word);
            result.append(" ");
        }
        return result.toString().trim();
    }
}