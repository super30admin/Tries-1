// Time Complexity : O(Nl) + O(Ml) where l is the average word length, N is the number of dictionary words and M is the number of words in the sentence
// Space Complexity : O(Nl) + O(Ml)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Created a trie for dictionary words. If a bigger word was found in the dictionary when adding the words, we will return since we just care about the smallest word.
 * Iterate through the words in the sentence and do a lookup in trie to find a smaller match. If match was found, replace the word with the match. Otherwise keep the same word in the dictionary.
 */
class Solution {
    TrieNode root;

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int ch = word.charAt(i) - 'a';
                if (curr.children[ch] == null) {
                    curr.children[ch] = new TrieNode();
                }

                if (curr.isEnd)
                    return;
                curr = curr.children[ch];
            }

            curr.isEnd = true;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();

        for (String word : dictionary) {
            root.insert(word);
        }

        StringBuilder result = new StringBuilder();
        for (String word : sentence.split(" ")) {
            StringBuilder currStr = new StringBuilder();
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                // if no match found or we are at the end of a smallest match
                if (curr.children[ch - 'a'] == null || curr.isEnd)
                    break;
                currStr.append(ch);
                curr = curr.children[ch - 'a'];
            }
            // if at smallest match in dictionary, add the dictionary word
            if (curr.isEnd) {
                result.append(currStr);
            }
            // add the current word since the smallest match from dictionary was not found
            else {
                result.append(word);
            }

            result.append(" ");
        }

        // trimming to get rid of the last space in the sentence
        return result.toString().trim();
    }


}