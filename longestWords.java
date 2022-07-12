// TimeComplexity : O(nk) where 'n' is the number of words nad each word of 'k' length
// SpaceComplexity: O(nk)
// Did your code successfully executed on leetcode : Yes
class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            this.children  = new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    StringBuilder maxStr;
    public String longestWord(String[] words) {
        root = new TrieNode();
        maxStr = new StringBuilder();
        for(String word: words){
            insert(word);
        }
        backtrack(root, new StringBuilder());
        return maxStr.toString();
    }
    
    private void backtrack(TrieNode curr, StringBuilder currStr){
        if(currStr.length()>maxStr.length()){
            maxStr = new StringBuilder(currStr);
        }
        for(int i=0;i<26;i++){
            if(curr.children[i]!= null && curr.children[i].isEnd){
                int le = currStr.length();
                currStr.append((char)(i+'a'));
                backtrack(curr.children[i], currStr);
                currStr.setLength(le);
            }
        }
    }
    
}
