/*
Time Complexity:    O(nL) where n is no. of words and L is max length of one word
Space Complexity:   O(nL)  - max space occupied by the Trie, there is also space occupied by new sentence which is again
                    O(nL) and so total space complexity would be O(nL+nL) = O(nL)
Passed all test cases on leetcode

Approach:
1.  Insert all new possible words to the Trie.
2.  For each old word (split in the sentence by a space such that it also removed extra white spces), check whether any subword is present in the Trie as a word
    and if present replace the subword with the old word and otherwise leave the old word as is.
3.  Return the sentence containing replaced words.

*/
class Solution {
    TrieNode root;
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        for(String s: dict) {
            insert(s);
        }
        String[] sentenceArr = sentence.split("\\s+"); // ensures extra spaces are removed and converts to array by removing spaces
        StringBuilder result = new StringBuilder();
        for(int k=0;k<sentenceArr.length;k++) {
            String word = sentenceArr[k];
            if(k>0) result.append(" ");
            // try to find replacement of each word in trie
            TrieNode curr = root;
            StringBuilder replStr = new StringBuilder();
            for(int i=0;i<word.length();i++) {
                char c = word.charAt(i);
                if(curr.children[c-'a']==null || curr.isEnd) break;
                replStr.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd) {
                result.append(replStr);
            } else {
                result.append(word);
            }
        }
        return result.toString();
    }
}