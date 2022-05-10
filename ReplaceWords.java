// Time Complexity : O(ml)
// Space Complexity :  O(nk + ml)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode() {
            children = new TrieNode[26]; 
        }
    }
    TrieNode root = new TrieNode();
    
    
    public void insert(String word) {
        TrieNode curr = root;
        
        for(char ch: word.toCharArray()) {
            if(!curr.isEnd) {
                if(curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
        }
        curr.isEnd = true;
    }
    
    
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
        if(dictionary == null || dictionary.size() == 0) return sentence;
        
        StringBuilder result = new StringBuilder();
        
        for(String word: dictionary) {
            insert(word);
        }
        
        String[] input = sentence.split(" ");
        
        for(int i = 0; i < input.length; i++) {
            TrieNode curr = root;
            String inp = input[i];
            StringBuilder res = new StringBuilder();
            
            if(i != 0) {
                result.append(" ");
            }
            
            for(char ch: inp.toCharArray()) {
                if(curr.children[ch - 'a'] == null || curr.isEnd) {
                    break;
                }
                curr = curr.children[ch - 'a'];
                res.append(ch);
            }
            
            if(curr.isEnd) {
                result.append(res);
            } else {
                result.append(inp);
            }
            
        }
        
        return result.toString();
    }
}