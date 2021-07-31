// 648. Replace Words - https://leetcode.com/problems/replace-words/
// Time Complexity : O(NK + L) [N: words, K: characters]
// Space Complexity : O(NK +L)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
   
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            //if letter doesn't exist, then create a node
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();
            //if letter exists, then move curr to children
            curr = curr.children[c-'a'];
        }
        //set the end letter node to true
        curr.isEnd = true;
    }
        
    public String replaceWords(List<String> dictionary, String sentence) {
        
        if(dictionary == null || dictionary.size() == 0)
            return sentence;
        
        //build trie
        root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        
        String[] SplitArray = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for(int j=0; j<SplitArray.length; j++){
            
            //append space to result after first word in the sentence 
            if(j>0) result.append(' ');
            TrieNode curr = root;
            
            String word = SplitArray[j];
            StringBuilder replacement = new StringBuilder();
            
            for(int i=0; i<word.length();i++){
                char c = word.charAt(i);
                
                //if letter doesnt exist or it found the word, then break the loop
                if(curr.children[c-'a'] == null || curr.isEnd) break;
                //if found the letter, move the curr to next node
                curr = curr.children[c-'a'];
                replacement.append(c);
            }
            
            //reached end of the root(did find prefix)
            if(curr.isEnd){
                result.append(replacement.toString());
            } else {
                //didn't find 
                result.append(word);
            }
        }
        
        return result.toString();    
    }
}