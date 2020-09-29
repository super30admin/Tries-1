//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root;
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
        root = new TrieNode();
        
        for(String word: dictionary){
            insert(word);
        }
        
        String []sentenceArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for(int k = 0; k < sentenceArr.length; k++){
            
            if(k > 0){
                result.append(" ");
            }
            TrieNode curr = root;
            StringBuilder currStr = new StringBuilder();
            String word = sentenceArr[k];
            
            for(int i = 0; i < word.length(); i++){
                
                char ch = word.charAt(i);
                
                if(curr.children[ch - 'a'] == null ||
                    curr.isWord == true){
                    break;
                }
                
                currStr.append(ch);
                curr = curr.children[ch - 'a'];
                
            }
            
            if(curr.isWord == true){
                result.append(currStr);
            }else{
                result.append(sentenceArr[k]);
            }
            
        }
        
        return result.toString();
        
    }
    
    private void insert(String word){
        
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i++){
            
            char ch = word.charAt(i);
            
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            
            curr = curr.children[ch - 'a'];
            
        }
        
        curr.isWord = true;
        
    }
}
