//Time Complexity : O(nl) where n is the length of words array and l is the average
  	//length of each word
  	//Space Complexity : O(n) for trie
  	//Did this code successfully run on Leetcode : Yes
  	//Any problem you faced while coding this : yes

public class LargestWordinDictionary {
    
}
class Solution {
    
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        char c;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            
            curr = curr.children[c-'a'];
            curr.c = c;
        }
        curr.isEnd = true;
    }
    
    String res = "";
    public String longestWord(String[] words) {
        if(words == null || words.length == 0){
            return res;
        }
        root = new TrieNode();
        
        for(String word: words){
            insert(word);
        }
        dfs(root, new StringBuilder());
        return res;
    }
    
    private void dfs(TrieNode node, StringBuilder sb){
        //base
        if(sb.length() >= res.length()){
            res = sb.toString();
        }
        
        //logic
        for(int i=25; i>=0; i--){
            TrieNode curr = node.children[i];
            if(curr != null && curr.isEnd){
                sb.append(curr.c);
                dfs(curr, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
