// Time Complexity : O(m*l) + O(n*k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.awt.*;

public class ReplaceWords {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root;

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String s: dictionary) {
            insert(s);
        } // O(m*l)
        String[] strArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int j = 0; j < strArr.length; j++) { // O(n*k) n words of length k
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            String word = strArr[j];
            if(j > 0) result.append(" ");
            for(int i = 0 ; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null || curr.isEnd) break;
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd) {
                result.append(replacement);
            }
            else {
                result.append(word);
            }
        }
        return result.toString();
    }
}
