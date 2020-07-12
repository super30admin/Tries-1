// Time Complexity :O(nl) n is the number of words and l is the length of the words;
// Space Complexity :O(l) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    TrieNode root;
    class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
        }
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i<word.length();i++){
            if(curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        
        curr.word = word;
        
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        for(String s : dict){
            insert(s);
        }
        
        StringBuilder sb = new StringBuilder();
        String[] senArr = sentence.split("\\s+");
        for(int i =0;i<senArr.length;i++){
            String sword = senArr[i];
            TrieNode curr = root;
            if(i>0) sb.append(" ");
            for(int j=0;j<sword.length();j++){
                char c  = sword.charAt(j);
                if(curr.children[c-'a'] == null || curr.word !=null) break;
                curr = curr.children[c-'a'];
            }
            
            String replacement;
            if(curr.word==null){
                replacement = sword;
            }
            else
            {
                 replacement = curr.word;
            }
            sb.append(replacement);
        }
        
        return sb.toString();
    }
}