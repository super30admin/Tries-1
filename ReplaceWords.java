//https://leetcode.com/problems/replace-words
//TC : O(N * l)
//SC : O(N * l) N- words in dictionary , l - avg length of the word

class Solution {
    class TrieNode{
        TrieNode [] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(List<String> dictionary){
        root = new TrieNode();
        for(String str : dictionary){
            TrieNode curr = root;
            for(char c : str.toCharArray()){
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
        }
    }
    private String replacementWord(String word){
        TrieNode curr = root;
        StringBuilder s = new StringBuilder();
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null) {
                return word;
            }
            s.append(c);
            curr = curr.children[c-'a'];
            if(curr.isEnd) return s.toString();
        }
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        insert(dictionary);
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for(String s : words){
            sb.append(" ").append(replacementWord(s));
        }
        return sb.toString().trim();
    }
}
