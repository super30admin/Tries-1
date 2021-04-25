// M : No of words
//N : Avg. length of word
// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class TrieNode{
    TrieNode[] children;
    String word;
    TrieNode(){
        children = new TrieNode[26];
        word = null;
    }
}

class Solution {
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || sentence.length() == 0) return "";
        root= new TrieNode();
        StringBuilder result = new StringBuilder();
        for(String word:dictionary){
            insert(word);
        }
        
        String[] words = sentence.split(" ");
        for(int j = 0 ; j < words.length ; j++){
            if(j > 0) result.append(" ");
            String word = words[j];
            TrieNode curr = root;
            for(int i = 0 ; i < word.length() ; i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null || curr.word != null){
                    break;
                }
                curr = curr.children[c-'a'];
            }
            if(curr.word == null) result.append(word);
            else result.append(curr.word);
        }
        return result.toString();
    }
}
