// Time Complexity : O(N*L), where N is the number of words in the dictionary and L is the length of the word
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * 1. Create a TrieNode class with children array and isEnd boolean and insert method.
 * 2. Load the words from the dictionary into the Trie.
 * 3. Split the sentence into words and iterate over each word.
 * 4. For each word, iterate over the characters and check if the character is present in the children array.
 * 5. If not, break and append the word to the result. If yes, append the character to the replaceWord and move to the next character.
 * 6. If the current node isEnd, append the replaceWord to the result. Else, append the word to the result.
 * 7. Return the result.
 */

import java.util.List;

class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word, TrieNode root){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String word : dictionary){
            insert(word, root);
        }

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        for(String word : words){
            TrieNode curr = root;
            StringBuilder replaceWord = new StringBuilder();
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                if(curr.children[ch - 'a'] == null || curr.isEnd)
                    break;
                replaceWord.append(ch);
                curr = curr.children[ch - 'a'];
            }
            if(curr.isEnd){
                result.append(replaceWord.toString());
            }else {
                result.append(word);
            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}