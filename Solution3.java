import java.util.List;

// Time Complexity O(m*n) for ibuilding the dictionary+O(kl)(k words in a sentence with average length l)
// Space Complexity :O(m*n*26) for each character we have an array of 26 length and one bool variable+O(kl) for string array (k words in a  sentence with average length l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approachclass Solution {
    class Solution3{
    TrieNode root;
    
    class TrieNode {
        
        TrieNode[] children;
        boolean isEnd;
            
            TrieNode(){
            children = new TrieNode[26];
            isEnd=false;
        }
    }
        public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char c= word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']= new TrieNode();
            }
            curr= curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary==null||dictionary.size()==0)
            return sentence;
        StringBuilder result= new StringBuilder();
        root= new TrieNode();
        for(String word:dictionary){
            insert(word);
        }
        
        String []words=sentence.split(" ");
        
        for(int i=0;i<words.length;i++){
            
            String word=words[i];
            StringBuilder replacement= new StringBuilder();
            TrieNode curr=root;
            for(int j=0;j<word.length();j++){
            char c= word.charAt(j);
            if(curr.children[c-'a']==null || curr.isEnd==true ){
                break;
            }
                replacement.append(c);
                curr= curr.children[c-'a'];
        }
            if(curr.isEnd==true){
                result.append(replacement);
                
            }
            else{
                result.append(word);
            }
            result.append(" ");
}
     return result.toString().trim();   
    }
    }
