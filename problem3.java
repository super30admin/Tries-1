package Tries-1;

public class problem3 {
    class Solution {
//TC:- O(n*l + m*k) n and l for trie length and word length and m and k is for sentence length and words length.
//SC:- O(n*l + m*k) n and l for trie length and word length and m and k is for sentence length and words length.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        children = new TrieNode[26];
    }
}
TrieNode root;

public void insert(String word){
    TrieNode curr = root;
    for(int i = 0; i < word.length(); i++){
        char c = word.charAt(i);
        if(curr.children[c - 'a'] == null){
            curr.children[c - 'a'] = new TrieNode();
        }
        curr = curr.children[c - 'a'];
    }
    curr.isEnd = true;
}

public String replaceWords(List<String> dictionary, String sentence) {

    if(dictionary == null || dictionary.size() == 0) return sentence;
    root = new TrieNode();
    
    for(String word : dictionary){
        insert(word);
    }
    
    String[] strArray = sentence.split(" ");
    StringBuilder result = new StringBuilder();
    
    for(int i = 0; i < strArray.length; i++){
        if(i != 0){
            result.append(" ");
        }
        String word = strArray[i];
        StringBuilder currSb = new StringBuilder();
        TrieNode curr = root;
        for(int j = 0; j < word.length(); j++){
            char c = word.charAt(j);
            if(curr.children[c - 'a'] == null || curr.isEnd){
                break;
            }
            currSb.append(c);
            curr = curr.children[c - 'a'];        
        }
        
        if(curr.isEnd){
            result.append(currSb.toString());
        }else{
            result.append(word);
        }
    }
    return result.toString();
}
}
}
