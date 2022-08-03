
// Time Complexity :O(ml)+O(nk) where m is no of dictionary words and n is no of words in sentence
// l and k are respective average length of words
// Space Complexity :O(ml)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    TrieNode root = new TrieNode();

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        // creating trie from dictionary given
        for (String dicItem : dictionary) {
            TrieNode curr = root;
            for (int i = 0; i < dicItem.length(); i++) {
                char c = dicItem.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();

                }
                // System.out.println("inside trie "+c);
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }
        // checking each word in sentence
        String[] wordArray = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < wordArray.length; i++) {
            String wordItem = wordArray[i];
            StringBuilder sb = new StringBuilder();
            TrieNode curr = root;
            for (int j = 0; j < wordItem.length(); j++) {
                char c = wordItem.charAt(j);
                // if any of trie's children is null that means there is no such word in
                // dictionary
                // if we found isEnd that means we got our word from dictionary, in both the
                // cases we'll stop
                if (curr.children[c - 'a'] == null || curr.isEnd)
                    break;
                sb.append(c);
                curr = curr.children[c - 'a'];
            }
            if (curr.isEnd) {
                wordArray[i] = sb.toString();
            }
            if (i != 0) {
                res.append(" ");
            }
            res.append(wordArray[i]);
        }
        return res.toString();
    }
}