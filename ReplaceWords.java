// Time Complexity : O(m*n). m is the length of the dictionary. n is the number of words in the sentence
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    TrieNode root;
     class TrieNode{
        String word;
        TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
     /** Inserts a word into the trie. */
    public void insert(String words) {
        TrieNode currentPtr = root;
        
        for(int i=0;i<words.length();i++){
            char currChar = words.charAt(i);
            
            if(currentPtr.children[currChar-'a']==null){
                currentPtr.children[currChar-'a']=new TrieNode();
            }
            currentPtr = currentPtr.children[currChar-'a'];
        }
        
        currentPtr.word = words;
    }
    
    public String replaceWords(List<String> dict, String sentence) {
         root = new TrieNode();
        
        //inserting all dictionary words
        for(String singleWord:dict){
            insert(singleWord);
        }
        
        String[] successorArray = sentence.split("\\s+");
        StringBuilder s = new StringBuilder();
        
        for(int i=0;i<successorArray.length;i++){
            String currentWord = successorArray[i];
            
            TrieNode currNode = root;
            if(i>0) s.append(" ");
            
            for(int j=0;j<currentWord.length();j++){
                char currChar = currentWord.charAt(j);
                
                if(currNode.children[currChar-'a']==null || currNode.word!=null) break;
                currNode =currNode.children[currChar-'a'];
            }
            
            if(currNode.word==null) s.append(currentWord);
            else s.append(currNode.word);
            
            
        }
        return s.toString();
        
    }
}

