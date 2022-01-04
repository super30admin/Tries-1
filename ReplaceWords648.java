/* Time Complexity : O(N*M)for inserting into trie + O(N) for splitting words into tokens + 0(KM) for searching k words of length M in trie.
 Space Complexity :  O(K*M) for storing results + split sentence to tokens + O(N*M) to build a trie from dictionary.
 where N is dictionary size and M is length of each string.
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No


/*
1. Build a trie using words given in dictionary
2. split the words in sentence and search if the part of it exists as a word (not prefix) in trie.
3. Add it to result if exists, otherwise add same word.
*/
class Solution {
    class TrieNode{
        TrieNode children[];
        boolean is_end;
        TrieNode(){
            children = new TrieNode[26];
            is_end = false;
        }
    }
    TrieNode root = new TrieNode();
    void insert(String word){
        TrieNode curr;
        curr = root;
        for(int i =0 ; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.is_end = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String word : dictionary){
            insert(word);
        }
        String words[] = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i<words.length ; i++){
            if( i != 0){
                result.append(" ");
            }
          StringBuilder replacemnt  = new StringBuilder();
         String currentString = words[i];
         TrieNode curr = root;
            for( int j = 0 ; j<currentString.length() ; j++){
                int index = currentString.charAt(j) - 'a';
                if(curr.children[index] == null || curr.is_end) break;
                replacemnt.append(currentString.charAt(j));
                curr = curr.children[index];
            }
            if(curr.is_end){
                result = result.append(replacemnt);
            }else{
                result = result.append(currentString);
            }
        }
    
        return result.toString();
        
    }
}
