// Time Complexity : O(n*l + m*l) where n is no of words in sentence and l is avg length of words and m is words in dict
// Space Complexity : O(nl) where n is no of words in sentence and l is avg length of words
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class ReplaceWords {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word : dictionary){
            insert(word);
        }

        String [] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i=0;i<words.length;i++){
            String word = words[i];
            if(i!=0) result.append(" ");
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int j=0;j<word.length();j++){
                char c = word.charAt(j);
                if(curr.children[c-'a']==null || curr.isEnd){
                    break;
                }
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd){
                result.append(replacement);
            }
            else{
                result.append(word);
            }
        }

        return result.toString();
    }

    public static void main(String [] args){
        ReplaceWords rw = new ReplaceWords();
        String [] dictionary = new String[]{"cat","bat","rat"};
        String sentence = "the cattle was rattled by the battery";
        System.out.println(rw.replaceWords(Arrays.asList(dictionary), sentence));
    }
}