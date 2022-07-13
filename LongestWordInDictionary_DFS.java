/* Time Complexity : O(nk)
 * Space Complexity : O(nk), for trie
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

class Solution {
    class TrieNode{
        TrieNode [] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word) {
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
    StringBuilder maxStr;
    public String longestWord(String[] words) {
        root = new TrieNode();
        maxStr = new StringBuilder();
        for(String word: words){ //nk
            insert(word);
        }
        backtrack(root, new StringBuilder());
        return maxStr.toString();
    }
    private void backtrack(TrieNode curr, StringBuilder currStr){//nk
        //base
        if(currStr.length() > maxStr.length()){
            maxStr = new StringBuilder(currStr);
        }
        //logic
        for(int i = 0; i < 26; i++){
            if(curr.children[i] != null && curr.children[i].isEnd){
                int le = currStr.length();
                //action
                currStr.append((char)(i + 'a'));
                //recurse
                backtrack(curr.children[i], currStr);
                //backtrack
                currStr.setLength(le);
            }
        }
    }
}

