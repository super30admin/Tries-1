//Time Complexity: O(nk + lk) // where n and l are lengths of array and sentence respectively and k is length of the string
//Space Complexity: O(nk + lk) // where n and l are lengths of array and sentence respectively and k is length of the string

import java.util.*;
class Solution {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;

    private void insert(String word) {
        TrieNode curr = root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c- 'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();

        for(String word: dictionary) {
            insert(word);
        }

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");

        for(int i = 0; i < words.length; i++) {
            if(i != 0) {
                result.append(" ");
            }
            String word = words[i];
            TrieNode curr = root;
            StringBuilder intermediate = new StringBuilder();
            for(int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);

                if(curr.children[c - 'a'] == null || curr.isEnd == true) {
                    break;
                }

                curr = curr.children[c - 'a'];
                intermediate.append(c);
            }

            if(curr.isEnd == true) {
                result.append(intermediate);
            }
            else {
                result.append(word);
            }
        }

        return result.toString();
    }
}
