//Time Complexity: O(N) where N is the length of the sentence. Every query of a word is in linear time.
//Space Complexity: O(N), the size of our trie.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class ReplaceWords {
   
        class TrieNode{
            TrieNode[] children;
            boolean isEnd;
            public TrieNode(){
                this.children = new TrieNode[26];
            }
        }
    
        TrieNode root;
    
        public String replaceWords(List<String> dictionary, String sentence) {
            root = new TrieNode();
            insertWord(dictionary);
            return replaceWord(sentence);
        }
    
        private void insertWord(List<String> dictionary){
            for (String str : dictionary){
                TrieNode curr = root;   
                for (int i=0; i<str.length();i++){
                    if (curr.children[str.charAt(i)-'a'] == null){
                        curr.children[str.charAt(i)-'a'] = new TrieNode();
                    }
                    curr = curr.children[str.charAt(i)-'a'];
                }
                curr.isEnd = true;
            }
        }
    
        private String replaceWord(String sentence){
            StringBuilder sb = new StringBuilder();
            String[] words=sentence.split(" ");
            for (String word : words){
                TrieNode curr = root;
                StringBuilder temp = new StringBuilder();
                for (char ch : word.toCharArray()){
                    if (curr.children[ch-'a'] == null){
                        break;
                    } else {
                        temp.append(""+ch);
                        curr = curr.children[ch-'a'];
                    }
                    if (curr.isEnd) break;
                }
                if (curr.isEnd){
                    sb.append(temp+" ");
                } else {
                    sb.append(word+" ");
                }
            }
            return sb.toString().trim();
        }
    }
