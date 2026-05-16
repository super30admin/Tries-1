// Time Complexity : O(n * l + m * l) where n is dictionary size, m is number of words in sentence, and l is average word length
// Space Complexity : O(26 * n * l) in the worst case for storing Trie nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use a Trie to store all dictionary root words so that prefixes can be searched efficiently character by character.
// For every word in the sentence, we traverse the Trie to find the shortest matching root and stop early if a valid root word is found or no further path exists.
// If a matching root is found, we replace the word with the root; otherwise, we keep the original word unchanged.

class Solution {
    class TrieNode {
        TrieNode [] children;
        boolean isEnd;
        
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    public void insert(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for (String word: dictionary) {
            insert(word);
        }

        String [] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i=0; i<words.length; i++) {
            if (i>0) {
                result.append(" ");
            }
            String currWord = words[i];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for (int j=0; j<currWord.length(); j++) {
                char ch = currWord.charAt(j);
                if (curr.isEnd || curr.children[ch-'a']==null) {
                    break;
                } 
                replacement.append(ch);
                curr = curr.children[ch-'a'];
            }
            if (curr.isEnd) {
                result.append(replacement.toString());
            } else {
                result.append(currWord);
            }

        }
        return result.toString();
    }
}