// Time Complexity : O(n*c)
// Space Complexity : O(n*c)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We create a class TrieNode to keep track of the different possible words.
    We search for each of the sentence words in the dictionary we have formed using the TrieNodes.
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
        
    public void insert(String word){
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++){
            if (curr.children[word.charAt(i) - 'a'] == null)
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }
    
    
    public String replaceWords(List<String> dictionary, String sentence) {
     
        root = new TrieNode();
        
        for (String word : dictionary) insert(word);
        
        String[] sentenceWords = sentence.split(" ");
        
        StringBuilder result = new StringBuilder();
        for (int j=0; j<sentenceWords.length; j++){
            
            if (j != 0) result.append(" ");
            
            String s = sentenceWords[j];
            
            TrieNode curr = root;
            StringBuilder sb = new StringBuilder();
            boolean flag = false; 
            for (int i=0; i<s.length(); i++){

                if (curr.children[s.charAt(i) - 'a'] == null) {
                    flag = true;
                    break;
                }
                
                curr = curr.children[s.charAt(i) - 'a'];
                
                sb.append(s.charAt(i));
                
                if (curr.isEnd) break;
            }
            if (flag){
                result.append(s);
            } else {
                result.append(sb.toString());
            }
        }
            
        return result.toString();
    }
}