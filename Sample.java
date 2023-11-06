// # Tries-1

// ## Problem1 
// Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)

// Time Complexity : O(l)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0; i< prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}

// ## Problem3
// Replace Words (https://leetcode.com/problems/replace-words/)

// Time Complexity : O(n*l + l*m)
// Space Complexity : O(n * l)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.


class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    
    public void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String word : dictionary){
            insert(root, word);
        }
        String[] strArr =sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int k=0; k< strArr.length; k++){
            TrieNode curr = root;
            String word = strArr[k];
            StringBuilder replacement = new StringBuilder();
            for(int i=0; i< word.length(); i++){
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null || curr.isEnd){
                    break;
                }
                curr = curr.children[c - 'a'];
                replacement.append(c);
            }
            if(curr.isEnd){
                result.append(replacement);
            }else{
                result.append(word);
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}
