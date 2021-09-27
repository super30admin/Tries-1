import java.util.*;


public class Tries {
//time complexity : N
//space complexity : N
// did it run on leetcode : yes
// any doubts : no
//https://leetcode.com/problems/replace-words/submissions/
    class TrieNode{
        boolean isend;
        TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[26];    
        }
    }
    TrieNode root;
     public void insert(String word) {
            TrieNode curr = root;
            char c;
            for(int i =0;i<word.length();i++){
                c = word.charAt(i);
                if(curr.children[c-'a']== null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isend = true;
            
        }
        public String replaceWords(List<String> dictionary, String sentence) {
            root = new TrieNode();
            for(String word : dictionary){
                insert(word);
            }
            StringBuilder result = new StringBuilder();
            String[] words = sentence.split(" ");
            for(String word : words){
                StringBuilder replacement = new StringBuilder();
                TrieNode curr = root;
                for(int i =0;i<word.length();i++){
                    char c = word.charAt(i);
                    if(curr.children[c-'a']== null || curr.isend== true) break;
                    replacement.append(c);
                    curr= curr.children[c-'a'];
                }
                if(curr.isend){
                    result.append(replacement).append(" ");
                }else{
                     result.append(word).append(" ");
                }
               
                
            }
            
            return result.toString().trim();
        }
    
    
//time complexity : N
//space complexity : N
// did it run on leetcode : yes
// any doubts : no
//https://leetcode.com/problems/longest-word-in-dictionary/submissions/
    public String longestWord(String[] words) {
        String result = "";
        Arrays.sort(words);
        HashSet<String> set = new HashSet<>();
        for(String word : words){
            if(word.length() == 1 || set.contains(word.substring(0,word.length()-1))){
                if(word.length()>result.length()){
                    result = word;
                    
                }
                set.add(word);
            }
        }
        return result;
    }
