// Time Complexity : O(N * L))
// Space Complexity : O(N * L) N = number of words L = length of longest word
//O(n*l) - for constructor, n - no of words, l - average length of words
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

class Solution {
    class TriNode{
        TriNode [] children;
        boolean isEnd;
        String word;
        public TriNode(){
            this.children = new TriNode[26];
            this.word = "";
        }
    }
    TriNode root;
    private void insert (String word){
        TriNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TriNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
        curr.word = word;
    }
    
    public String longestWord(String[] words) {
        root = new TriNode();

        for(String word: words){
            insert(word);
        }
        Queue<TriNode> q = new LinkedList<>();
        q.add(root);
        TriNode curr = root;
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i >= 0; i--){
                if(curr.children[i] != null && curr.children[i].isEnd){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
    
}

/*
class Solution {
    class TriNode{
        TriNode [] children;
        boolean isEnd;
        public TriNode(){
            this.children = new TriNode[26];
        }
    }
    TriNode root;
    private void insert (String word){
        TriNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TriNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    StringBuilder sb;
    StringBuilder maxStr;
    public String longestWord(String[] words) {
        root = new TriNode();
        sb = new StringBuilder();
        maxStr = new StringBuilder();
        for(String word: words){
            insert(word);
        }
        backtrack(root, new StringBuilder());
        return maxStr.toString();
    }
    private void backtrack(TriNode curr, StringBuilder currStr){
        //base
        if(currStr.length() > maxStr.length()){
            maxStr = new StringBuilder(currStr); //if new StringBuilder not used -> we will loose String in backtracking
        }
        
        //logic
        for(int i = 0; i < 26; i++){ // as each children has 26 characters
            if(curr.children[i] != null && curr.children[i].isEnd){
                int le = currStr.length();
                //action
                currStr.append((char)(i + 'a')); //adding the ASQII value
                //recurse
                backtrack(curr.children[i], currStr);
                //backtrack
                currStr.setLength(le);
            }
        }
    }
}
*/