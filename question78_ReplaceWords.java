package Tries1;

import java.util.List;

public class question78_ReplaceWords {
    /* Created by palak on 7/2/2021 */

    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
    */
    TrieNode root;
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length() ; i++) {
            char c = word.charAt(i);
            //An Optimization
            if(curr.isEnd) break;
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word: dictionary) { // Complexity: NK: n: no of words in dictionary and k: average length of the work
            insert(word);
        }
        StringBuilder result = new StringBuilder();
        String[] sentenceArray = sentence.split("\\s+"); // O(N) for the split array
        for(int k = 0 ; k < sentenceArray.length ; k++) { //Complexity: O(L); L: total number of characters in the string
            if(k > 0) result.append(" "); //append O(1)
            String word = sentenceArray[k];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            // Searching the Character in the TrieNode
            for(int i = 0 ; i < word.length() ; i++) {
                char c = word.charAt(i);
                //now check for the character
                if(curr.children[c - 'a'] == null || curr.isEnd) break;
                curr = curr.children[c - 'a'];
                replacement.append(c); //append O(1)
            }
            if(curr.isEnd) { //found smaller prefix
                result.append(replacement);
            } else { // the corresponding smaller prefix is not in the Trie
                result.append(word); //append O(1)
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

    }
}
