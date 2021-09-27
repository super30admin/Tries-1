// Time Complexity : O(L)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word: dictionary){ // O(m * k)
            insert(word);
        }
        StringBuilder result = new StringBuilder();
        String[] splitArr = sentence.trim().split(" ");
        for(String word: splitArr){ // O(n * L)
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null || curr.isEnd) break;
            replacement.append(c);
            curr = curr.children[c-'a'];
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