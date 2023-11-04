// Time Complexity : O(NL * ml)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


public class ReplaceWords {
    class Solution {
        class TrieNode{
            boolean isEnd;
            TrieNode[] children;

            public TrieNode(){
                this.isEnd = false;
                this.children = new TrieNode[26];
            }
        }

        TrieNode root;

        private void insert(String word){
            TrieNode cur = root;
            int wordLen = word.length();

            for(int i = 0; i < wordLen; i++){
                char c = word.charAt(i);
                if(cur.children[c - 'a'] == null){
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = true;
        }

        public String replaceWords(List<String> dictionary, String sentence) {
            this.root = new TrieNode();
            for(String word : dictionary){
                insert(word);
            }

            String[] strArr = sentence.split(" ");
            int strArrLen = strArr.length;
            StringBuilder result = new StringBuilder();

            for(int i = 0; i < strArrLen; i++){
                if(i > 0)
                    result.append(" ");

                String word = strArr[i];
                int wordLen = word.length();
                StringBuilder sb = new StringBuilder();
                TrieNode cur = root;

                for(int j = 0 ; j < wordLen; j++){
                    char c = word.charAt(j);
                    if(cur.children[c - 'a'] == null || cur.isEnd == true){
                        break;
                    }
                    cur = cur.children[c - 'a'];
                    sb.append(c);
                }
                if(cur.isEnd)
                    result.append(sb);
                else
                    result.append(word);
            }
            return result.toString();
        }
    }
}
