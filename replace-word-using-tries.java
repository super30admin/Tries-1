import java.util.*;

class Solution {
    // Trie Solution
    // Time complexity is O(m*l) + O(n*k) 
    // O(m*l) is for creating trie
    // O(n*k) is for search where k is the average length
    // Space complexity is O(n*L) where n is the number of words and L is the length
    // Let me know if space complexity is correct
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    // Keep root trienode global
    TrieNode root;
    
    public String replaceWords(List<String> dictionary, String sentence) {
        // Edge case
        if(sentence == null || sentence.length() == 0) return sentence;
        StringBuilder result = new StringBuilder();
        root = new TrieNode();
        
        // Creating a dictionary of trienode first
        for(String s : dictionary){
            insert(s);
        }
        
        String [] split = sentence.split(" ");
        
        for(int j = 0; j<split.length; j++){
            if(j>0) result.append(" ");
            String word = split[j];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int k = 0; k<word.length();k++){
                char c = word.charAt(k);
                if(curr.children[c-'a'] == null || curr.isEnd){
                    break;
                }
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd)
                result.append(replacement);
            else
                result.append(word);
        }
        return result.toString();
    }
    
    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
}