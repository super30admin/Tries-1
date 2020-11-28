// Time Complexity :  O(N) chars in words
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    class TrieNode{
        TrieNode[] children;
        String word;
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode node = root;
        for(int i = 0; i< word.length();i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c-'a'];
        }
        node.word = word;
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        TrieNode curr = null;
        Queue<TrieNode> q = new LinkedList();
        for(String w: words){
            insert(w);
        }
        q.add(root);
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i >= 0; i--){
                if(curr.children[i]!=null && curr.children[i].word!=null){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}