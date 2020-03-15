// Time Complexity : O(m) m-> length of the sentence
// Space Complexity :  O(l*n); l-> average length of each word in dictionary; n -> no. of words in dictionary
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach: A trie datastructure is used to insert and retrieve the words in a fast manner.
// All words in dictionary are inserted in trie. Here, along with the children represented by 26 characters, the word in dictionary is also maintained.
// Whenever a non null word is observed in trie, it is added in result, otherwise original word is added.

class Solution {
    
    class TrieNode {
        String word;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root = new TrieNode();
    
    private void insert(String word) {
        char[] wordChar = word.toCharArray();
        TrieNode curr = root;
        for(char ch : wordChar) {
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.word = word;
    }
    public String replaceWords(List<String> dict, String sentence) {
        // edge case check
        if(dict == null || sentence == null) return sentence;
        
        // inserting dictionary words in trie datastructure  
        for(int i = 0; i < dict.size(); i++) {
            insert(dict.get(i));
        }
        // creating an array of string by splitting sentence based on space
        String[] words = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder(); // for storing result
        for(String wrd : words) {
            char[] chArr = wrd.toCharArray();
            TrieNode curr = root;
            for(char ch : chArr) {
                if(curr.children[ch-'a'] == null || curr.word != null) {
                    break;
                }
                else {
                    curr = curr.children[ch-'a'];
                }
            }
            if(curr.word != null) {
                sb.append(curr.word);
            }
            else {
                sb.append(wrd);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}

