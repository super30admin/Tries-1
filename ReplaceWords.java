// Time Complexity : O(np) where n is the number of words and p is the number of chars in the word
// Space Complexity : O(n) // stringBuilder
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Building the prefix Trie by scanning the input array.
//Whenever it reaches th ened of the word in the trie, replacing it and appending it to the SB.

import java.util.List;

public class ReplaceWords {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        private TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String str:dictionary){
            insert(str);
        }

        StringBuilder result = new StringBuilder();
        String[] splitArr = sentence.split("\\s+");
        TrieNode curr;

        for(int k=0;k<splitArr.length; k++){
            if(k>0){
                result.append(' ');
            }
            String s = splitArr[k];
            curr = root;

            StringBuilder replacementStr = new StringBuilder();
            for(int i=0; i<s.length();i++){
                char ch = s.charAt(i);
                if(curr.children[ch-'a'] == null || curr.isEnd){
                    break;
                }
                replacementStr.append(ch);
                curr = curr.children[ch-'a'];
            }

            if(curr.isEnd){
                result.append(replacementStr);
            }else{
                result.append(s);
            }
        }
        return result.toString();
    }
}
