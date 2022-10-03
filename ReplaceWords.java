import java.util.List;

/*
## Problem3
Replace Words (https://leetcode.com/problems/replace-words/)

Time Complexity :   O (nk+mk) 
Space Complexity :  O (n) 
Did this code successfully run on Leetcode :    Yes (648. Replace Words)
Any problem you faced while coding this :       No
 */
// Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
// Output: "the cat was rat by the bat"

class ReplaceWords {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word) {
        TrieNode curr = root;
        
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        
        // create trie for dictionary
        for(String str: dictionary){
            insert(str);
        }
        
        StringBuilder result = new StringBuilder();
        String[] strArr = sentence.split(" ");
        
        for(int k=0; k< strArr.length; k++){
            String word = strArr[k];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            
            for(int i=0; i< word.length(); i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null || curr.isEnd){
                    break;
                }
                replacement.append(c);
                curr = curr.children[c -'a'];
            }
            if(curr.isEnd){
                // replacement string found
                result.append(replacement);
            }else{
                result.append(word);
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}