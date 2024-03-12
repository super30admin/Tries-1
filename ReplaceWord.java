// Time Complexity : O((n * W) + (N + S)) [w: number of characters in each word; n: number of words in the dictionary; W: ∑(w);]
// Space Complexity : O(n * W)            [N: number words in the sentence; s: number of character in each word in the Sentence; S: ∑(s);]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.List;

class Solution {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode parent;

        Trie() {
            this.parent = new TrieNode();
        }

        private void insert(String word) {
            TrieNode curr = this.parent;
            char a = 'a';
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (null == curr.children[ch - a]) {
                    curr.children[ch - a] = new TrieNode();
                }
                curr = curr.children[ch - a];
            }
            curr.isEnd = true;
        }

        private String searchReplacement(String word) {
            StringBuilder sb = new StringBuilder();
            TrieNode curr = this.parent;
            char a = 'a';
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (null == curr.children[ch - a]) {
                    return word;
                }

                sb.append(ch);
                curr = curr.children[ch - a];
                if (curr.isEnd == true) {
                    return sb.toString();
                }

            }
            return word;
        }

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();

        Trie trie = new Trie();
        for (String str : dictionary) {
            trie.insert(str);
        }
        String[] strArr = sentence.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            sb.append(trie.searchReplacement(strArr[i]));
            if (i != strArr.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}