// Time Complexity : O(nl); l - length of word
// Space Complexity : O(nl)
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

public class LongestWordInDictionary {

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i< word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
        curr.word = word;
    }

    public String LongestWordInDictionary(String[] words) {
        root = new TrieNode();
        String result = "";

        //build trie
        for(String word : words){
            insert(word);
        }
        //bfs
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = root;
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i>= 0; i--){
                if(curr.children[i] != null && curr.children[i].isEnd){
                    q.add(curr.children[i]);
                }
            }
        }
        if(curr.word == null) return "";
        return curr.word;
    }
}
