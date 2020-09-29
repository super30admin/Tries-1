// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach







class Solution {
    
    class TrieNode{
        TrieNode [] child;
        boolean isWord;
        public TrieNode(){
            child = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root; 
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        
        for( String str : dictionary){
            TrieNode curr = root;
            
            for(int i=0; i<str.length(); i++ ){
                
                char ch = str.charAt(i);
                
                if(curr.child[ch - 'a'] == null){
                    curr.child[ch - 'a'] = new TrieNode();
                }
                curr= curr.child[ch - 'a'];
            }
            curr.isWord = true;
        }
        
        StringBuilder result = new StringBuilder();
        String str[] = sentence.split(" ");
        
        for(int i=0;i<str.length; i++){
            if(i>0) result.append(" ");
            String word = str[i];
            TrieNode curr = root;
            StringBuilder sb = new StringBuilder();
            
            for(int j=0;j<word.length(); j++){
                char curChar = word.charAt(j);
                if(curr.child[curChar - 'a'] == null || curr.isWord){
                    break;
                }
                curr = curr.child[curChar - 'a'];
                sb.append(curChar);
            }
            
            if(curr.isWord == true){
                result.append(sb);
            }else{
                result.append(word);
            }
            
        }
        return result.toString();
    }
}
