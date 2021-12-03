// Replace Words
// solved on leetcode
// Time Complexity : Length of the word
// Space Complexity :  O(n*k)

class Solution {
    
    class TrieNode {
        boolean isEnd;
        TrieNode [] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    private void insert(String word){
        TrieNode curr = root;
        
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            
            if(curr.children[ch-'a']== null ){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr= curr.children[ch-'a'];
        }
        curr.isEnd= true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        
        for(int i=0;i<dictionary.size();i++){
            insert(dictionary.get(i));
        }
        
        String [] sentenceArray = sentence.split(" ");
        StringBuilder replacement = new StringBuilder();
        for(String word: sentenceArray){
           
            StringBuilder temp = new StringBuilder();
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                
                char ch = word.charAt(i);
                if(curr.children[ch-'a']== null || curr.isEnd==true){
                    break;
                }
                temp.append(ch);
                curr= curr.children[ch-'a'];
            }
            if(curr.isEnd==true){
                replacement.append(temp + " ");
            }else{
                replacement.append(word + " ");
            }
            
        }
        return replacement.toString().trim();
    }
}