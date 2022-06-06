// Time Complexity :O(m*l) m=dictionary size l=length of word
// Space Complexity : O(n) n=size of trie
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    
    class TrieNode{
        TrieNode [] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;    
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        StringBuilder result = new StringBuilder();
        
        //insert in Trie the words of the dictionary
        for(String s:dictionary){
            insert(s);
        }
        
        //iterate over words in the sentence
        String[] strArr = sentence.split(" ");
        for(int j=0;j<strArr.length;j++){
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            if(j>0){
                result.append(" ");
            }
            String word = strArr[j];
            //iterate over each word
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c-'a']==null || curr.isEnd){
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
