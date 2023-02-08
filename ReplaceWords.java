// Time Complexity : O(NK + ML)
// Space Complexity : O(NK)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// N is the number of words in dictionary & K is the average length of each word in dictionary
// M is the length of words in sentence & L is the avg length of each word in the sentence

public class ReplaceWords {
    static class Solution {
        class TrieNode{
            boolean isEnd;
            TrieNode[] children;

            public TrieNode(){
                children = new TrieNode[26];
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

        public String replaceWords(List<String> dictionary, String sentence) {
            root = new TrieNode();
            for (String str : dictionary) {
                insert(str);
            }

            StringBuilder result = new StringBuilder();
            String[] strArr = sentence.split(" ");
            for (int k = 0; k < strArr.length; k++) {
                String word = strArr[k];
                TrieNode curr = root;
                StringBuilder replacement = new StringBuilder();

                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (curr.children[c - 'a'] == null || curr.isEnd) {
                        break;
                    } else {
                        replacement.append(c);
                        curr = curr.children[c - 'a'];
                    }
                }
                if (curr.isEnd) {
                    result.append(replacement);
                } else {
                    result.append(word);
                }
                result.append(" ");
            }
            return result.toString().trim();
        }
    }
}
