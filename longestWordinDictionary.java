// M : No of words
// N : Avg length of words
// Time Complexity : O(M*N)
// Space Complexity : O(M * N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class TrieNode{
    String word;
    TrieNode[] children;
    public TrieNode(){
        this.children = new TrieNode[26];
        this.word = null;
    }
}

class Solution {
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }
    public String longestWord(String[] words) {
        root= new TrieNode();
        for(String word : words){
            insert(word);
        }
        
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = root;
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25 ; i >= 0 ; i--){
                if(curr.children[i] != null && curr.children[i].word != null){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}
