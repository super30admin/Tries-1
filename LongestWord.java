// Time Complexity : O(26^L)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class LongestWord {
    class Solution {
        class TrieNode{
            boolean isEnd;
            TrieNode[] children;

            public TrieNode(){
                this.isEnd = false;
                children = new TrieNode[26];
            }
        }
        TrieNode root;

        private void insert(String word){
            TrieNode cur = root;
            int wordLen = word.length();

            for(int  i = 0; i < wordLen; i++){
                char c = word.charAt(i);
                if(cur.children[c - 'a'] == null){
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = true;
        }

        private String result;
        public String longestWord(String[] words) {
            root = new TrieNode();
            result = "";

            for(String str : words){
                insert(str);
            }
            dfs(root, new StringBuilder());

            return result;
        }

        private void dfs(TrieNode root, StringBuilder sb){
            //logic
            for(int i = 0; i < 26; i++){
                if(root.children[i] != null && root.children[i].isEnd){
                    //action
                    sb.append((char)('a'+i));
                    //recurse
                    dfs(root.children[i], sb);

                    if(sb.length() > result.length()){
                        result = sb.toString();
                    }

                    //backtrack
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
