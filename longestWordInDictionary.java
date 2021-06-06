//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    
    class TrieNode{
        
        TrieNode[] children;
        String word;
        
        public TrieNode(){
            
        children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void enterData(String word){
         TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i ++){
           
            char ch = word.charAt(i);
            //  System.out.println(word.length());
          //  System.out.println(ch);
            
            if(curr.children[ch - 'a'] == null){
                
                curr.children[ch - 'a'] = new TrieNode();
            }
            
          curr = curr.children[ch - 'a'];
                
                
            
        }
        curr.word = word;
    }
    public String longestWord(String[] words) {
        
        if(words.length == 0 || words[0] == null){
            
            return "";
        }
        root = new TrieNode();
        for(int i = 0; i < words.length; i ++){
            
           //   System.out.println(words[i]);
            enterData(words[i]);
        }
        Queue<TrieNode> q1 = new LinkedList<>();
        TrieNode curr = root;
        q1.add(curr);
        while(!q1.isEmpty()){
            
            curr = q1.poll();
           
             for(int j = 25; j >= 0; j -- ){
                    
                   if(curr.children[j] != null && curr.children[j].word != null){
                        
                        q1.add(curr.children[j]);
                    }
                }
            
        }
        if(curr.word == null){
            
            return "";
        }
        return curr.word;
    }
}