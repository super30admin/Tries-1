//tc: O(n*l) insering into the trie n-dict wors, l-length of each word
//sc: O(n*l) 
//leetcode : successful
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
        
    }
    TrieNode root;
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null)
                curr.children[ch-'a'] = new TrieNode();
            else
                curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();   
        for(String str: dictionary){ //tc : m*l  m - words in dict, l-length of each word
            insert(str);
        }
        StringBuilder result = new StringBuilder();
        String [] Array_strings = sentence.split(" ");
        for(int i=0;i<Array_strings.length;i++){
            if(i!=0){
               result.append(" "); 
            }
            String curr_word = Array_strings[i];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            
            for(int k=0;k<curr_word.length();k++){
                char letter = curr_word.charAt(k);
                if(curr.children[letter-'a']==null || curr.isEnd){
                   break;  
                }
                    replacement.append(letter);
                    curr = curr.children[letter-'a'];
            }
            if(curr.isEnd)
                result.append(replacement);
            else
                result.append(curr_word);
        }
        return result.toString();
         
    }
}