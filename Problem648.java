// Time Complexity : O(n * m * L)
//where n is the number of words in sentence, L - length of each word, m - length of word in dictionary
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Split the words in string, check the prefix is present in Trie structure 
 * if yes, replace the prefix in the original sentence
 */
import java.util.*;
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    public void construct(String word, TrieNode curr) {
        for(int i=0;i< word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c -'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWord(String s, TrieNode root){
        String res = "";
        for(int i=0; i< s.length(); i++){
            char c= s.charAt(i);
            if(root.children[c-'a'] == null){
                return s;
            }
            res = res+c;
            root = root.children[c-'a'];
            if(root.isEnd == true){
                return res;
            }
           
        }
        return s;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        StringBuilder ans = new StringBuilder();
        for(String s : dictionary){
            construct(s, root);
        }
        String[] sentenceList = sentence.split(" ");
        for(String s : sentenceList){
            String temp = replaceWord(s, root);
            if(ans.length()>0){
                ans.append(" "+ temp);
            }
            else{
                ans.append(temp);
            }
        }
        return ans.toString();
}}