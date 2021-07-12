// Time Complexity : O(NK+L) : L length of chars in the input, NK - to build the TRIE
// Space Complexity : O(NK+L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

class Solution {
    TrieNode root = new TrieNode();
    public void insert(String word){
        TrieNode curr = root; 
        for (int i = 0 ; i < word.length(); i++){
            char ch = word.charAt(i);
            if (curr.children[ch-'a'] == null){
                TrieNode node = new TrieNode();
                curr.children[ch-'a'] = node;
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd= true;
    }
    
    public StringBuilder startsWith(String word){
         TrieNode curr = root;
         StringBuilder small= new StringBuilder();
         for (int i = 0 ; i < word.length(); i++){
          char ch = word.charAt(i);   
            if (curr.children[ch-'a'] == null || curr.isEnd) break;
             small.append(ch);
             curr = curr.children[ch-'a'];
        }
        // there isn't any smaller world
        if (curr.isEnd != true ) return null;
        // return the smallest word found
        return small;
    } 
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
        // Make a trie prefix tree 
        // check if every word in give line starts with any of the sequence in prefix tree. If yes, replace it with smallest word, else keep the original word
        
        for (String word: dictionary){
            insert(word);
        }
        
        // convert the given sentence to list of words
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < words.length; i++){
            if (i > 0) sb.append(" ");
            String myWord = words[i];
            StringBuilder smaller  = startsWith(myWord) ;
            if (smaller != null ){
                // if there exists a smaller prefix, add the prefix
                sb.append(smaller);
            } else {
                // keep the original word as is
                sb.append(myWord);
            }           
        }
        return sb.toString();
    }   

}

class TrieNode{
    boolean isEnd; 
    TrieNode[] children;
    public TrieNode(){
        this.children = new TrieNode[26];
    }
}
