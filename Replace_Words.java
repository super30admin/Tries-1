/*
 * TC: O(mn), m: no. of words in dictionary, n: avg length of the word in dictionary.
 * SC: O(mn) m: no. of words in dictionary, n: avg length of the word in dictionary.
 * 
 * Approach: insert words from dictionary into Trie. Do prefix Check on each word from the sentence and keep updating the result
 */


class TrieNode{
    boolean isEndWord;
    String nodeWord;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }
}

class Solution {
    StringBuilder result = new StringBuilder();
    TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for(String word : dictionary) {
            insertWord(word);
        }

        String[] str = sentence.split(" ");
        for(String word : str){
            checkPrefix(word);
        }
    return result.toString().trim();    
    }

    public void insertWord(String word) { //O(n)
        TrieNode curr = root;

        for(int i = 0; i< word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';

            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
      curr.isEndWord = true;
      curr.nodeWord = word;
    }

    private void checkPrefix(String word) { 
        TrieNode curr = root;

         for(int i =0; i<word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';

            if(curr.children[index] == null || curr.isEndWord) break;

            curr = curr.children[index];
        }
        if(curr.isEndWord){
            result.append(curr.nodeWord +" ");
        }else{
            result.append(word+" ");
        }
    return;
    }


}