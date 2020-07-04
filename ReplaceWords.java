// Time Complexity : Insertion: O(n * l) & Searching O(m * l) --> where l is average length of words in the dictionary; n is the number of words in the dictionary; m is the number of words in the sentance
// Space Complexity : Storing dictionary in tries: O(n * l) & replacing word: O(l)
// Did this code successfully run on Leetcode (648) : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    
    class TrieNode {
        boolean isEnd;
        TrieNode children[];
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    /** Initialize your data structure here. */
    TrieNode root;
        
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        for (String s : dict) {
            insert(s);
        }
        StringBuilder sb = new StringBuilder();
        String sentenceArr[] = sentence.split("\\s+");
        
        for (int i = 0; i < sentenceArr.length; i++) {
            String sWord = sentenceArr[i];
            TrieNode curr = root;
            if (i > 0) sb.append(" ");
            StringBuilder replaceSb = new StringBuilder();
            for (int j = 0; j < sWord.length(); j++) {
                char c = sWord.charAt(j);     
                if (curr.children[c - 'a'] == null || curr.isEnd) break;
                replaceSb.append(c);
                curr = curr.children[c - 'a'];
            }
            String replacement;
            if (!curr.isEnd) replacement = sWord;
            else replacement = replaceSb.toString();
            sb.append(replacement);
        }
        return sb.toString();
    }
}