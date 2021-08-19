//Time complexity: O(r*d + n), where d is the size of the dictionary list and r is the maximum length of a word in dictionary amd n is the length of sentence
//Space complexity: O(r*d), nodes in trie

import java.util.*;

class Solution3 {
    class Trie {
        class TrieNode {
            TrieNode links[]; 
            boolean isEnd; 
            
            public TrieNode() {
                links = new TrieNode[26];             
            }            
        }
        
        TrieNode root; 
        
        public Trie() {
            root = new TrieNode(); 
        }
        
        public void insert(String word) {
            TrieNode node = root;
            for(char c: word.toCharArray()) {
                if(node.links[c-'a'] == null) {
                    node.links[c-'a'] = new TrieNode(); 
                }
                node = node.links[c-'a']; 
            }
            node.isEnd = true; 
        }
        
        public String getRoot(String word) {
            TrieNode node = root;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i); 
                if(node.links[c-'a'] == null) break; 
                node = node.links[c-'a']; 
                if(node.isEnd == true) return word.substring(0,i+1);   
            }
            return word;
        }
    }
    
    
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0) return sentence; 
        Trie trie = new Trie(); 
        for(String root: dictionary) {
            trie.insert(root); 
        }
        
        String words[] = sentence.split(" "); 
        StringBuilder output = new StringBuilder(); 
        for(String word: words) {
            output.append(trie.getRoot(word));
            output.append(" ");
        }
        
        output.setLength(output.length()-1); 
        
        return output.toString(); 
    }
}