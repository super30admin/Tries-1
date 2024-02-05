/*
* Approach:
*  1. Insert all words into trie. 
    Then initialize the stringbuilder of word and global longestword.
    Trigger the recursion with word and curr node.
* 
*  2. Iterate from the last children 'z'
    because we need lexicographically smallest word.
        if any child is not null, 
            check if it is forming a single word with the addition of character.
            (node.isEnd == true)
            if not, we dont have to expand on that node.
* 
*  3. Keep building the word once above conditions are valid,
        update the longest word if small
        backtrack the action to revert to previous state
            (because we are using stringbuilder - reference)
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(W*n)
    W = total no of words
    n = max word size
* 
* Space Complexity: O(W*n)
* 
*/

class LongestWord {
    class TrieNode{
         TrieNode[] children;
         boolean isEnd;
 
         public TrieNode(){
             children = new TrieNode[26];
             isEnd = false;
         }
     }
 
     TrieNode root;
 
     private void insertIntoTrie(String word){
         TrieNode curr = root;
 
         for(char ch: word.toCharArray()){
             int index = ch - 'a';
 
             if(curr.children[index] == null){
                 curr.children[index] = new TrieNode();
             }
 
             curr = curr.children[index];
         }
 
         curr.isEnd = true;
 
     }
 
     String longestWord;
 
     private void getLongestWord(StringBuilder word, TrieNode curr){
         for(int index = 25; index>=0; index--){
             if(curr.children[index]!=null && curr.children[index].isEnd){
                 word.append((char)(97+index));
 
                 if(longestWord == "" || longestWord.length() <= word.length()){
                     longestWord = word.toString();
                 }
 
                 getLongestWord(word, curr.children[index]);
                 
                 word.deleteCharAt(word.length()-1);
             }
         }
     }
 
     public String longestWord(String[] words) {
         root = new TrieNode();
 
         for(String word: words){
             insertIntoTrie(word);
         }
 
         TrieNode curr = root;
 
         longestWord = "";
 
         StringBuilder word = new StringBuilder();
         
         getLongestWord(word, curr);
 
         return longestWord;
     }
 }