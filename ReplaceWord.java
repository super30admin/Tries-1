// Time Complexity : O(NL + NK)
// Space Complexity : O(NL) L is length of word
// Did it run on Leetcode: Yes

class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    
    public void insert(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char c= word.charAt(i);
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        String[] split = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < split.length; i++) { 
            if (i != 0) {
                res.append(" ");
            }
            String word = split[i];
            StringBuilder sb = new StringBuilder();
            TrieNode curr = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (curr.children[c - 'a'] == null || curr.isEnd) {
                    break;
                }
                sb.append(c);
                curr = curr.children[c - 'a'];
            }
            if (curr.isEnd) {
                res.append(sb.toString());
            } else {
                res.append(word);
            }
        }
        return res.toString();
    }
}