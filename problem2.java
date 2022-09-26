
//Problem2 - Longest Word in Dictionary(https://leetcode.com/problems/longest-word-in-dictionary/)

// Time Complexity : O(nk + ml)
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially struggled with optimized solution

public class problem2 {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
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
        for(String str : dictionary){
            insert(str);
        }
        
        StringBuilder result = new StringBuilder();
        String[] strArr = sentence.split(" ");
        
        for(int k=0;k<strArr.length;k++){
            String word = strArr[k];
            StringBuilder replacement = new StringBuilder();
            
            TrieNode curr = root;
            if(k!=0) result.append(" ");
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null || curr.isEnd){
                    break;
                }
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            
            if(curr.isEnd){
                result.append(replacement);
            }else{
                result.append(word);
            }
        }
        return result.toString();
    }
}
