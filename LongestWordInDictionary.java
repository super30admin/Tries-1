// Time Complexity : O(W*L)(to create Tries) + O(W*L) iterate through the tries, W = #Words, L=Avg Word Length
// Space Complexity : O(W*L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class LongestWordInDictionary {
    class Solution {

        class TrieNode{
            TrieNode[] children;
            boolean isEnd;

            TrieNode() {
                children = new TrieNode[26];
            }

        }

        private TrieNode root;

        private void  insert(String word) {
            TrieNode curr = root;
            for(int i=0; i< word.length(); i++){
                char c = word.charAt(i);
                if(curr.children[c  - 'a'] == null) {
                    curr.children[c  - 'a'] = new TrieNode();
                }
                curr = curr.children[c  - 'a'];
            }
            curr.isEnd = true;
        }
        public String longestWord(String[] words) {
            //initialize the root
            root = new TrieNode();
            //create a Trie Datastructure
            for(String word : words) {
                insert(word);
            }
            StringBuilder result = new StringBuilder();
            //find the logest word with most complete words as prefix
            int globalCount = 0;
            for(String word : words) {
                int count = 0;
                TrieNode curr = root;
                for(int i=0; i< word.length(); i++){
                    char c = word.charAt(i);
                    if(curr.children[c  - 'a'] == null) break;
                    if(curr.children[c  - 'a'].isEnd) {
                        count+=1;
                    }
                    curr = curr.children[c  - 'a'];
                }
                if(globalCount == count && word.compareTo(result.toString()) < 0 && count == word.length()) {
                    result.replace(0, result.length()+1, word);
                }

                if(globalCount < count && count == word.length()) {
                    globalCount = count;
                    result.replace(0, result.length()+1, word);
                }
            }
            return result.toString();
        }
    }
}
