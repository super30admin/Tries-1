/*

Longest Word in Dictionary(https://leetcode.com/problems/longest-word-in-dictionary/)
Time Complexity : O(n*l) 
Space Complexity : O(n*l) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/

class Solution {

    public class TrieNode{
        String str;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    Queue<TrieNode> q;
    String result; 

    private void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.str = word;
    }

    public String longestWord(String[] words) {
        if (words == null || words.length == 0){
            return "";
        }
        
        root = new TrieNode();
        for(String word : words){
            insert(word);
        }

        q = new LinkedList<TrieNode>();
        q.add(root);
        TrieNode curr = new TrieNode();

        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i >= 0; i--){
                if(curr.children[i] != null && curr.children[i].str != null){
                    q.add(curr.children[i]);
                }
            }
        }
        if (curr != null && curr.str != null){
            return curr.str;
        }
        return "";
    }
}