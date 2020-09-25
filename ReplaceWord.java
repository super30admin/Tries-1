// Time Complexity : O(n) for each operation
// Space Complexity : O(n) n is number of characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Using Trie
class Solution {
    private TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        if(sentence == null || sentence.length()==0)
            return sentence;
        
        root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        
        StringBuilder sb = new StringBuilder();
        
        String[] words = sentence.split("\\W+");
        for(String w: words){
            if(sb.length() > 0){
                sb.append(" ");
            }   
            String resSearch = searchInTrie(w);
            if(resSearch!=null){
                sb.append(resSearch);
            }else{
                sb.append(w);
            }
        }
        return sb.toString();
    }
    
    private String searchInTrie(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null || curr.word != null){
                break;
            }
            curr = curr.children[c-'a'];
        }
        return curr.word; 
    }
    
    private void insert(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word; 
    }
}

class TrieNode{
    TrieNode[] children;
    String word;
    
    TrieNode(){
        children = new TrieNode[26];
    }
}