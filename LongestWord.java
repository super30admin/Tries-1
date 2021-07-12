// Time Complexity : O(L) : L sum of length of all the words
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

class TrieNode{
    String word;
    TrieNode[] children;
    public TrieNode(){
        this.children = new TrieNode[26];
    }
}
class Solution {
    TrieNode root = new TrieNode();
     public void insert(String word){
        TrieNode curr = root;
        for (int i = 0 ; i < word.length(); i++){
             char ch = word.charAt(i);
            if (curr.children[ch-'a'] == null){
                  curr.children[ch-'a'] = new TrieNode();
            }

             curr = curr.children[ch-'a'];
        }
        curr.word = word;

    }
    public String longestWord(String[] words) {

        // add all the words to the prefix tree and check for the length of longest word
        for (String wordl: words){
            insert(wordl);
        }
        // traverse from z - a as it maintians the lexicographical order of the nodes
        Queue<TrieNode> queue  = new LinkedList<>();
        TrieNode curr = null;
        queue.add(root);
        while(!queue.isEmpty()){
             curr = queue.poll();
            for (int i = 25; i >= 0 ; i--){
                if (curr.children[i] != null && curr.children[i].word != null){
                    queue.add(curr.children[i]);
                }
            }
        }
        
        return curr.word == null ? "" :curr.word;
    }
}
