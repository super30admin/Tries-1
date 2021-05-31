//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    
       class TrieNode{
        
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode(){
            
            this.children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        
        root = new TrieNode();
        
        for(int k = 0; k < dictionary.size(); k ++){
            
        String word = dictionary.get(k);
            
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i ++){
            
            char ch = word.charAt(i);
            
            if(curr.children[ch - 'a'] == null){//children doesnt contain the character of the word
                
                //curr.children[ch - 'a'] = new ; /////doubt
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        
        curr.isEnd = true;
            
        }  
        
        
        String[] word1 = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        StringBuilder replacement;
         //System.out.println(word1.length);
        for(int j = 0; j < word1.length; j ++){
            
            TrieNode curr = root;
            replacement = new StringBuilder();
            if(j != 0){
                
                result.append(" ");
            }
            
        for(int i = 0; i < word1[j].length(); i ++){
            //System.out.println("hitting");
            char ch = word1[j].charAt(i);
           // System.out.println(ch);
            
            if(curr.children[ch - 'a'] == null || curr.isEnd ){
              
                break;
                
            } 
            curr = curr.children[ch - 'a'];
            replacement.append(ch);
        }
        if(curr.isEnd){
           
            result.append(replacement);
        }
            else{
            //     System.out.println("hitting");
             result.append(word1[j]);
            }
            
        }
        
        
      return result.toString();
        
    }
}