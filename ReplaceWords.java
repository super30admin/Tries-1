// Time Complexity :  O(N) chars in sentencce
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    class TrieNode{
        TrieNode[] children;
        String word;
        TrieNode(){
            children = new TrieNode[26];
        }
        public void insert(String word){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(node.children[ c -'a'] == null){
                    node.children[ c -'a'] = new TrieNode();
                }
                node = node.children[ c -'a'];
            }
            node.word = word;
        }
        public String check(String word){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(node.children[c - 'a'] ==null){
                    return word;
                }else{
                    if(node.children[c-'a'].word != null){
                        return node.children[c-'a'].word;
                    }
                    node = node.children[ c-'a'];
                }
            }
            return word;
        }
    }
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String w: d){
            root.insert(w);
        }
        for(String w: words){
            sb.append(root.check(w));
            sb.append(" ");
        }
        
        return sb.toString().trim();
    }
}