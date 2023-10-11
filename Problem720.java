// Time Complexity : O(nlogn)+O(n * L) n- number of words, L-length of the word
// Space Complexity : O(n * L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Construct a Trie, after sorting the given list of words based on the length
 * While inserting the trie, check whether the previous character end is true 
 * Return the maximum length word in lexicographical order
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
    private String constructTrie(String word, TrieNode root){
        if(word.length() ==1 && root.children[word.charAt(word.length()-1)-'a'] == null){
            root.children[word.charAt(word.length()-1)-'a'] = new TrieNode();
            root.children[word.charAt(word.length()-1)-'a'].isEnd = true; 
            return word;
        } 
        else{
                for(int i=0; i< word.length()-1;i++){
                char c = word.charAt(i);
                if(root.children[c-'a'] == null){
                    root.children[c-'a'] = new TrieNode();
                    root.children[c-'a'].isEnd =false;
                }
                if(root.children[c-'a'].isEnd == false)
                    return "";
                root = root.children[c-'a'];
            }
            root.children[word.charAt(word.length()-1)-'a'] = new TrieNode();
            root.children[word.charAt(word.length()-1)-'a'].isEnd = true;
        }
        return word;
    }
    public String longestWord(String[] words) {
        String ans = "";
        TrieNode root = new TrieNode();
        Arrays.sort(words);
        for(String w : words){
            String temp = constructTrie(w, root);
            if(temp.length() > ans.length()){
                ans= temp;
            }
            else if(temp.length() == ans.length()){
                if(ans.compareTo(temp)>0){
                    ans= temp;
                }
            }
        }
        return ans;
    }
}