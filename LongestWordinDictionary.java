 // Time Complexity :  O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;
public class LongestWordinDictionary {
        class TrieNode{
            TrieNode[] children;
            boolean isEnd;
            public TrieNode(){
                children = new TrieNode[26];
            }
        }
        TrieNode root;
    
        public LongestWordinDictionary() {
            root = new TrieNode();
        }
    
        public String longestWord(String[] words) {
            Arrays.sort(words);
            if (words == null || words.length == 0) return null;
            for (String word : words){
                insert(word);
            }
    
            int len = 0;
            String result = "";
            for (String word : words){
                if(search(word) && word.length() > len){
                    System.out.println(word);
                    len= word.length();
                    result = word;
                }
            }
            return result;
        }
    
        public boolean search(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()){
                if (curr.children[ch-'a'] == null ){
                    return false;
                }
                curr=curr.children[ch-'a'];
                if (!curr.isEnd) return false;
            }
            if (curr.isEnd) return true;
            else return false;
        }
    
        public void insert(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()){
                if (curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr = curr.children[ch-'a'];
            }
            curr.isEnd = true;
        }
    
    
}
