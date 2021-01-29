// https://leetcode.com/problems/replace-words/
// Time complexity : O( (Number of words in dict * Average word length in dict) + (Number of words in sentence * Average word length in sentence)
// Space complexity : O(Number of words * Average length of word)
class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode children[] = new TrieNode[26];
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

        public String rootCheck(String word) {
            TrieNode curr = root;
            StringBuilder rootStr = new StringBuilder();
            for (char c : word.toCharArray()) {
                rootStr.append(c);
                if (curr.children[c - 'a'] == null) {
                    rootStr.setLength(0);
                    rootStr.append(word);
                    break;
                }
                if (curr.children[c - 'a'].isEnd == true) {
                    break;
                }
                curr = curr.children[c - 'a'];
            }
            return rootStr.toString();

        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary)
            trie.insert(word);

        String wordsArr[] = sentence.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (String word : wordsArr) {
            res.append(trie.rootCheck(word));
            res.append(" ");
        }
        res.setLength(res.length() - 1);
        return res.toString();

    }
}