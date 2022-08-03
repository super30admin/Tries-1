// Time Complexity : O(NL)
// Space Complexity : O(NL) L is length of word
// Did it run on Leetcode: Yes

class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        char chr;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    void insert(String word){
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(cur.children[index] == null){
                cur.children[index] = new TrieNode();
                cur.children[index].chr = c;
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }
    String result;
    int maxLen;
    
    public String longestWord(String[] words) {
        result = new String("");
        maxLen = -1;
        
        if(words == null || words.length == 0){
            return "";
        }
        root = new TrieNode();
        
        for(String word:words){
            insert(word);
        }
        
        StringBuilder curStr = new StringBuilder();
        helper(root,0,curStr);
        return result;
    }
    int helper(TrieNode cur, int len, StringBuilder curStr){
        if(cur == null){
            return -1;
        }
        
        //action
        if(len!=0){
           curStr.append(cur.chr);
        }
      
        if(cur.isWord && len > maxLen){
            maxLen = len;
            result = curStr.toString();
        }
        else if((len !=0) && (!cur.isWord)){
            return 0;
        }
          
        
        for(int i=0;i<26;i++){
            //recurse
            int returned = helper(cur.children[i],len+1, curStr);
            //backtrack
            if(returned !=-1){
                curStr.deleteCharAt(curStr.length()-1);
            }
        }
        return 0;
    }
}