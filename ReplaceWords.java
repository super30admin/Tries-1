// Time Complexity : O(L) l is the length of the sentence. Iterating char by char the total length. Insertion should be constant dictionary length O(n * m).
// Space Complexity : O(n * m * Total_Char_Size) n - no of dictionary keys, m - word size, ALphabets_Size = 26. If ascii also included then 255 
// Did this code successfully run on Leetcode : Yes;(https://leetcode.com/submissions/detail/658674077/)
// Any problem you faced while coding this : No.
// My Notes : Insert the dictionary words and while checking the sentence, check for match with char if exisits end

import java.util.List;
class TrieNode{
    final int ALPH_SIZE = 26;
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        this.children = new TrieNode[ALPH_SIZE];
        this.isEnd = false;
    }
}

class Solution {
    TrieNode trieRoot = null;

    public String replaceWords(List<String> dictionary, String sentence) {
        trieRoot = new TrieNode();
        // insert all keys
        for(String key : dictionary){
            insert(key);
        }
        // Check the prefic
        String[] words = sentence.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            String newWord = getPrefix(word);
            sb.append(newWord+" ");
        }
        
        return sb.toString().trim();
    }
    
    public String getPrefix(String word){
         TrieNode node = trieRoot;
        for(int i = 0;i< word.length();i++){
            char c = word.charAt(i);
            //System.out.println(" Checking char : "+c +" node : "+node.isEnd );
            // prefix doesnt exist
            if(node.children[c - 'a'] == null){
                return word;
            }
            node = node.children[c - 'a'];
            
            if(node.isEnd){
                return word.substring(0,i+1);
            }
        }
        return word;
    }
    
    public void insert(String word) {
        TrieNode node = trieRoot;
        for(int i = 0; i<word.length();i++){
            char c = word.charAt(i);
            int position = c -'a';
            if(node.children[position]==null){
                node.children[position] = new TrieNode();
            }
            node = node.children[position];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = trieRoot;
        for(int i = 0; i<word.length();i++){
            char c = word.charAt(i);
            int position = c -'a';
            if(node.children[position]==null){
                return false;
            }
            node = node.children[position];
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = trieRoot;
        for(int i = 0; i<prefix.length();i++){
            char c = prefix.charAt(i);
            int position = c -'a';
            if(node.children[position]==null){
                return false;
            }
            node = node.children[position];
        }
        return true;
    }
}