import java.util.List;

// Time Complexity : O(m), where m is the length of words
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class ReplaceWords {

    class Solution {

        //create trienode class
        class TrieNode{
            boolean isEnd;
            TrieNode[] children;

            //constructor
            public TrieNode(){
                this.isEnd = false;
                children = new TrieNode[26];
            }
        }

        //dummy root
        TrieNode root;

        private void insert(String word){
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null){
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
        }

        public String replaceWords(List<String> dictionary, String sentence) {
            root = new TrieNode();

            //insert dictionary words in to trie
            for(String word:dictionary){
                insert(word);
            }

            //split sentence in to words in an array
            String[] splitArray = sentence.split("\\s+"); //\\s+ to split due to multiple spaces
            StringBuilder result = new StringBuilder();

            TrieNode curr;
            StringBuilder replacement;

            for(int a = 0; a < splitArray.length; a++){

                //append space in between words
                if(a>0) result.append(' ');

                String word = splitArray[a];
                curr = root;
                replacement = new StringBuilder();

                //iterate over the charater and determine if it can be replaced
                for (int i = 0; i < word.length(); i++) {
                    char c= word.charAt(i);
                    if(curr.children[c-'a'] == null || curr.isEnd == true) break;
                    replacement.append(c);
                    curr = curr.children[c-'a'];
                }
                if(curr.isEnd){
                    result.append(replacement);
                }else{
                    result.append(word);
                }
            }
            return result.toString();
        }
    }


}
