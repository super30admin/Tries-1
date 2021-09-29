// Time Complexity : O(m*k + n*l), where m = number of words in dictionary, k = average length of each word, n = length of the sentence, l = average length of each word in sentence
// Space Complexity : O(m*k),
// Did this code successfully run on Leetcode : Yes


import java.util.*;
class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}
class Solution {
    TrieNode root;
    private void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c =  word.charAt(i);
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word : dictionary) 
            insert(word); // m * k
        
        String[] splitArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < splitArr.length; i++) {
            TrieNode curr = root;
            String word = splitArr[i];
            StringBuilder replacement = new StringBuilder();
            // search the possible replacement
            for(int j = 0;j < word.length(); j++) {
                char c = word.charAt(j);
                if(curr.children[c - 'a'] == null || curr.isEnd) break;
                replacement.append(c);
                curr = curr.children[c - 'a'];
            }
            if(curr.isEnd) {
                result.append(replacement);
                result.append(" ");
            } else {
                result.append(word);
                result.append(" ");
            }
        }
        return result.toString().trim();
    }
}