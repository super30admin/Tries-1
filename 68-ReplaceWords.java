/**
 * 
 * Time Complexity : O(np + mp) => m<<n so we can ignore it => O(np)
 * Space Complexity : we need to consider trie space. Trie's worst case: O(mp) //but they say dictionary is constant space in question. m-> no. of words p-> avg length of string
 So it would be constant space. O(1). We dont need to consider replacement's space. It is relative much smaller.
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * 

 we create trie for dictionary. 
 */
class Solution {
    
    class TrieNode{
        
        boolean isEnd;
        TrieNode[] children;
        
        private TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    private void insert(String word){
        
        TrieNode curr = root;
        for(int i = 0;i < word.length(); i++){
            
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
        for(String w: dictionary){   //if dict has m words with avg length of p //this for loop : O(mp)
            
            insert(w);
        }
        StringBuilder result = new StringBuilder();
        String[] splitArr = sentence.split("\\s+");  //eliminating multiple spaces incase if there are more than 1 space
        TrieNode curr;
        for(int k = 0; k<splitArr.length; k++){   //if length of splitArr is n   => O(np)
            
            if(k > 0) result.append(' ');
            String s = splitArr[k];
            curr = root;
            StringBuilder replacement = new StringBuilder();
            for(int i = 0; i<s.length(); i++){   //p 
                
                char c = s.charAt(i);
                if(curr.children[c - 'a'] == null || curr.isEnd) break;
                replacement.append(c);
                curr = curr.children[c - 'a'];
            }
            if(curr.isEnd){
                result.append(replacement);
            }
            else{
                result.append(s);
            }
        }
        
       return  result.toString();
    }
}