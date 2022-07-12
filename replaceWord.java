// Time Complexity : O(m*l + n*l) 
// Space Complexity : O(n*l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
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
        //tc = m * l + n * l
        for(String str: dictionary){ //m* l
            insert(str);
        }
        StringBuilder result = new StringBuilder();
        String [] strArr = sentence.split(" "); // n * l
        StringBuilder replacement = new StringBuilder();
        
        for(int k = 0; k < strArr.length; k++){
            String word = strArr[k];
            if(k != 0) result.append(" "); //for adding the space
            replacement = new StringBuilder();
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                 
                if(curr.children[c-'a'] == null || curr.isEnd){
                    break;
                }
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd){
                //we got the replacement
                result.append(replacement);
            } else{
                result.append(word);
            }
        }
        return result.toString();
    }
}
/*
class Solution{
    public String replaceWords(List<String> dictionary, String sentence){
        HashSet<String> set = new HashSet<>(dictionary);
        String [] strArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int j = 0; j < strArr.length; j++){
            String word = strArr[j];
            if(j > 0) result.append(" ");
            int prevlen = result.length();
            for(int i = 0; i < word.length(); i++){
                String sub = word.substring(0, i+ 1);
                if(set.contains(sub)){
                    result.append(sub);
                    break;
                }
            }
            if(prevlen == result.length()){
                result.append(word);
            }
        }
        return result.toString();
    }
}
*/