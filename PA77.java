//Leetcode : 648. Replace Words
//Time Complexity: O(nk) , where n is the number of words max of (sentence , ddictionary) and k is the average length of word.
//Space Complexity; O(nk) ,where n is the number of words max of (sentence , ddictionary) and k is the average length of word.
class Solution {
    class TrieNode{
        String word;
        TrieNode[] children;
        TrieNode(){
            children= new TrieNode[26];
        }
    }
    
    TrieNode root = new TrieNode();
    public void buildTrie(String word){
        TrieNode n= root;
        for(int i=0;i<word.length();i++){
            char c= word.charAt(i);
            if(n.children[c-'a']==null){
                TrieNode t= new TrieNode();
                n.children[c-'a'] = t;
            }
            n= n.children[c-'a'];
        }
        n.word = word;
    }
    
    public String searchWord(String word){
        TrieNode n= root;
        for(int i=0;i<word.length();i++){
            char c= word.charAt(i);
            if(n.word!=null){
                return n.word;
            }
            if(n.children[c-'a']==null){
                return word;
            }
          n=n.children[c-'a'];
        }
        return word;
    }
    public String replaceWords(List<String> dict, String sentence) {
        if(sentence== null || sentence.length()==0) return sentence;
        for(String s: dict){
            buildTrie(s);
        }
        StringBuilder result= new StringBuilder();
        String[] words =sentence.split("\\s+"); 
        for(int i=0;i<words.length;i++){
            if(i==0){
                result.append(searchWord(words[i]));
            }
            else{
                result.append(" ");
                result.append(searchWord(words[i]));
                
            }
            
        }
        return result.toString();
        
    }
}