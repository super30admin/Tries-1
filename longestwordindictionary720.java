// Time Complexity : O(m*k) k - number of words
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    String res ;
    TrieNode root;
    public String longestWord(String[] words) {
        root = new TrieNode();
        res = "";
        for(String w: words){
            insert(w);
        }
        helper(root,new StringBuilder());
        return res;
    }

    public void insert(String word){
        TrieNode current = root;
        for(int i = 0;i<word.length();i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.eof = true;
    }

    public void helper(TrieNode current, StringBuilder state){
        if(state.toString().length()>=res.length()){
            String temp = state.toString();
            if(temp.length()==res.length()){
                if(temp.compareTo(res)<0){
                    res = temp;
                }
            }
            else{
                res = temp;
            }


        }
        for(int i = 0;i<26;i++){
            if(current.children[i] != null && current.children[i].eof){
                state.append((char)(i+'a'));
                helper(current.children[i], state);
                state.deleteCharAt(state.length() - 1);
            }
        }
    }
}
class TrieNode{
    TrieNode[] children;
    boolean eof;
    TrieNode(){
        children = new TrieNode[26];
        eof = false;
    }
}