// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

class Solution {
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        String word = "";
    }
    
    public String searchPrefix(TrieNode node, String str) {
        TrieNode curr = root;
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(curr.children[ch - 'a'] == null || curr.isEnd){
                break;
            }
            curr = curr.children[ch - 'a'];
        }
        
        if(curr.isEnd == true)
            return curr.word;
        
        return "";
    }
    TrieNode root = new TrieNode();
    public String replaceWords(List<String> dictionary, String sentence) {
        
        
        // insert into trie
        for(String word : dictionary) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(curr.children[ch - 'a'] == null){
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
            curr.word = word;            
        }
        
        String[] strs = sentence.split(" ");
        String res = "";
        
        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String prefix = searchPrefix(root, str);
            if(!prefix.equals("")){
                res+= prefix;
            }
            else {
                res += str;
            }
            if(i != strs.length - 1)
                res+= " ";
            
        }
        return res;
    }
}