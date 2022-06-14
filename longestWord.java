// Time Complexity : O(n*l) - n =no of word, l=length of word
// Space Complexity : O(n*l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        String word;
        public TrieNode(){
            this.word = "";
            this.children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
        curr.isEnd = true;
    }
    
    
    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String word:words){
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = root;
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i=25;i>=0;i--){
                if(curr.children[i]!=null && curr.children[i].isEnd){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}