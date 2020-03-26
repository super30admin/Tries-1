//Problem3
// Replace Words (https://leetcode.com/problems/replace-words/)
//  Space - O(N*l) where l is the avg length of each string.  is the total number of strings - size of trie
// Time - O(N)
class Solution {
    class Trie{
        Trie[] children;
        String word;
        Trie(){
            children = new Trie[26];
        }
    }
    Trie root = new Trie();
    // Insert into a trie
    
    private void insertWord(String str){
        Trie curr = root;
        for(char c: str.toCharArray()){
            
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new Trie();
            }
            curr = curr.children[c - 'a'];
        }
        
        curr.word = str;
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        // Step 1: build a trie
        for(String word: dict){
            insertWord(word);
        }
      
        //Step 2: replace words
        
        StringBuilder sb = new StringBuilder();
        for(String wrd: sentence.split("\\s+")){
            if(sb.length() > 0)
                sb.append(" ");
            Trie curr = root;
            for(char c: wrd.toCharArray()){
                if(curr.children[c - 'a'] == null || curr.word != null) break;
                curr = curr.children[c -  'a'];
            }
            
            sb.append(curr.word != null ? curr.word : wrd);
               
        }
          
        
        
        return sb.toString();
    }
}