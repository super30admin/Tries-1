// Time Complexity : O(n)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Building the prefix Trie by scanning the input array.
//Adding the children nodes to the queue and implementing BFS

import java.util.LinkedList;
import java.util.Queue;

public class LongestWordInTheDictionary {
    class TrieNode{
        TrieNode[] children;
        String word;
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
        curr.word = word;
    }

    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String str : words){
            insert(str);
        }

        Queue<TrieNode> myQ = new LinkedList<>();
        myQ.add(root);
        TrieNode curr = null;
        while(!myQ.isEmpty()){
            curr = myQ.poll();
            for(int j=25; j>=0; j--){
                if(curr.children[j] != null && curr.children[j].word != null){
                    myQ.add(curr.children[j]);
                }
            }
        }
        return curr.word;
    }
}
