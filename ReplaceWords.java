//Time Complexity : O(nl+mk), where n is size of dictionary, l is the average length of each 
	//word in dictionary for making the trie, m is the total number of words in sentence and
	//k is the average length of each word in sentence
	//Space Complexity : O(nl), for trie
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : yes
import java.util.*;
public class ReplaceWords {
    
}
class Solution {
    
    class TrieNode{
        TrieNode children[];
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word) {
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
        for(String d: dictionary){
            insert(d);
        }
        String[] s = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length; i++){
            if(i > 0){
                sb.append(" ");
            }
            TrieNode curr = root;
            StringBuilder replace = new StringBuilder();
            for(int j=0; j<s[i].length(); j++){
                char c = s[i].charAt(j);
                replace.append(c);
                if(curr.children[c-'a'] == null){
                    break;
                }
                if(curr.children[c-'a'].isEnd){
                    curr = curr.children[c-'a'];
                    break;
                }
                
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd){
                sb.append(replace);
            }else{
                sb.append(s[i]);
            }
        }
        return sb.toString();
    }
}
