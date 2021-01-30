//Problem 78: Replace Words
//Assume dictionary contain n words, average size of each word m
//Assume sentence contain k words, average size of each word v
//Time Complexity: O(Max(O(n*m),O(k*v))), means max of (creating trie or search & replacement)
//Space Complexity : O(n*m), will not consider replacement part that is going to be very small in comparison to buildring trie

/*
 1) Create Trie
 2) Search and Replacement: Iterate over the given array with the help of current pointer and append the character to the string builder. If current pointer is null or is last character i.e isEnd==true, then just exit the iteration, Check whether it is last node or not. If it is last node, then just add it to the result otherwise reset the string builder. and append the whole word given in the sentence.
*/

import java.util.*;
class Solution78 {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        TrieNode(){
            children = new TrieNode[26];//because of 26 lowercase characters
        }
    }
    
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        //Assume dictionary contain n words, average size of each word m
        //Assume sentence contain k words, average size of each word v
        StringBuilder result = new StringBuilder();
        //edge
        if(dictionary==null || dictionary.size()==0 || sentence==null || sentence.length()==0){
            return result.toString();
         }
        
        //TOTAL : TC: O(Max(O(n*m),O(k*v))), means max of (creating trie or search & replacement)
        //        SC: O(n*m), will not consider replacement part that is going to be very small in comparison to buildring trie
        
        root = new TrieNode();
        
        //create trie
        //For all words : TC:O(n*m) | SC:O(n*m)
        for(String dict:dictionary){
            insert(dict);
        }
        
        String[] split = sentence.split("\\s");//if more than one space then ("\\s+")
        
        //word replacement
        //For all words : TC:O(k*v) | SC:won't consider replacement because its the output
        for(int i=0;i<split.length;i++){
            
            String word = split[i];
            
            if(i>0) result.append(" ");// for appending empty space
            
            StringBuilder replacement = searchReplacement(word);
            
            if(replacement.length()==0) result.append(word);
            else result.append(replacement);
            
        }
        
        return result.toString();
    }
    
    //insert in trie
    //For Single word : TC:O(word length) | SC:O(word length)
    private void insert(String word){
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a'] = new TrieNode();
            }
            
            curr = curr.children[ch-'a'];
        }
        
        curr.isEnd = true;
    }
    
    //search for replacement in trie
    //For Single word : TC:O(word length) | SC:O(word length), because of sb
    private StringBuilder searchReplacement(String s){
        
        StringBuilder sb = new StringBuilder();
        TrieNode curr = root;
        for(char ch:s.toCharArray()){
               if(curr.children[ch-'a']==null || curr.isEnd) break;//stop if no children or is End true because for returning smallest abbrevation
               sb.append(ch);
               curr = curr.children[ch-'a'];
        }
        
        if(!curr.isEnd) sb.setLength(0);//if curr was not ending character than reset the sb object
        
        return sb;
        
    }
    
}