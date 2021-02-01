import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m), where m is the length of words
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class LongestWordInDictionary {

    class Solution {
        //create trienode class
        class TrieNode{
            String word;
            TrieNode[] children;

            //constructor
            public TrieNode(){
                children = new TrieNode[26];
            }
        }

        //dummy root
        TrieNode root;

        //add characater to trie if doesn't exist and save the word at the last trie
        private void insert(String word){
            TrieNode curr = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.word = word;
        }

        public String longestWord(String[] words) {
            root = new TrieNode();

            //insert words in array in to trie
            for (String word:words){
                insert(word);
            }

            //Perform BFS search
            Queue<TrieNode> q = new LinkedList<>();

            TrieNode curr = root;
            q.add(curr);

            while(!q.isEmpty()){
                curr = q.poll();

                for (int i = 25; i>=0 ; i--) {
                    if(curr.children[i] != null && curr.children[i].word != null){
                        q.add(curr.children[i]);
                    }
                }
            }
            return curr.word;
        }
    }
}
