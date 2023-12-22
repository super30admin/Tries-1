// Longest Word in Dictionary

// Time Complexity : O(nl), where n is the number of words and l is the average length
// Space Complexity : O(26 * maxLen), where maxLen is the length of the longest word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    String result;
    public String longestWord(String[] words) {
        root = new TrieNode();
        result = "";
        for(String word: words){ // TC: O(nl), where n is the number of words and l is the average length
            insert(word);
        }
        backtrack(root, new StringBuilder());
        return result;
    }
    private void backtrack(TrieNode root, StringBuilder curr){
        // base
        if(curr.length() > result.length()){
            result = curr.toString();
        }
        // logic
        for(int i = 0; i < 26; i++){
            TrieNode child = root.children[i];
            if(child != null && child.isEnd){
                int l = curr.length();
                // action
                curr.append((char)('a' + i));
                // recurse
                backtrack(child, curr);
                // backtrack
                curr.setLength(l);
            }
        }
    }
}