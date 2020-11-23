// Time Complexity : O(N*P) where N is no of words in sentences and P is avg length of word
// Space Complexity : O(m) m is no of words in the dictionary
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * We are using to Trie Data structure to solve the problem. Build the trie with the words in the
 * dictionary and search for if the prefix are found for the words in the sentence
 * */


import java.util.List;

public class ReplaceWords {

    TrieNode root;

    private void insert(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for (String word : dictionary){
            insert(word);
        }

        String[] sentenceArr  = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        TrieNode curr;
        for(String word : sentenceArr){
            result.append(" ");
            curr = root;
            StringBuilder replacement = new StringBuilder();
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(curr.children[c-'a']==null || curr.isEnd){
                    break;
                }
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd){
                result.append(replacement);
            } else {
                result.append(word);
            }
        }
        return result.toString().trim();
    }

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public  TrieNode(){
            children = new TrieNode[26];
        }
    }
}
