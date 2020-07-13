// Time Complexity :O(nl) n is the number of words and l is the length of the words;
// Space Complexity :O(l) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    TrieNode root;
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            children = new TrieNode [26];
        } 
    }
    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        for(String s : dict){
            insert(s);
        }
        StringBuilder sb = new StringBuilder();
        String [] sentenceArr = sentence.split("\\s+");
        for(int i = 0; i < sentenceArr.length; i++){
            String sWord = sentenceArr[i];
            TrieNode curr = root;
            if(i > 0) sb.append(" ");   
            StringBuilder replaceSb = new StringBuilder();
            for( int k = 0; k < sWord.length(); k++){
                char c = sWord.charAt(k);
                if(curr.children[c - 'a'] == null || curr.isEnd)break;
                replaceSb.append(c);
                curr = curr.children[c - 'a'];
            }
            String replacement;
            if(!curr.isEnd){
                replacement = sWord;
            }else{
                replacement = replaceSb.toString();
            }
            sb.append(replacement);
            
        }
        return sb.toString();
    }
}