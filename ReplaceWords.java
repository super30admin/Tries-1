// Time complexity: O(wordsInDictionary * l) + O(wordsInSentence * l) where l = average length of word in dictionary 
// Space: O(wordsInDictionary * l) where l = average length of word in dictionary

// Approach: Creating a TrieNode using the dictionary words; For each word in sentence
// check the smallest string that exists starting from the first alphabet of sentence word
// replace it if it does; else keep the original word

import java.util.List;

class ReplaceWords {
    class TrieNode {
        String word;
        TrieNode[] children;

        public TrieNode() {
            this.word = "";
            this.children = new TrieNode[26];
        }
    }

    class Trie {

        TrieNode head;

        public Trie() {
            this.head = new TrieNode();
        }

        public void insert(String s) {
            TrieNode node = head;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            // storing word in node
            node.word = s;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        TrieNode head = trie.head;

        for (String s : dictionary) {
            trie.insert(s);
        }

        String[] strArr = sentence.split(" ", 0);
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                res.append(" ");
            }
            String s = strArr[i];
            TrieNode node = head;
            boolean wordFound = false;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (node.children[c - 'a'] == null) {
                    break;
                } else if (!node.children[c - 'a'].word.equals("")) {
                    // shortest word in dictionary found
                    res.append(node.children[c - 'a'].word);
                    wordFound = true;
                    break;
                }
                node = node.children[c - 'a'];
            }
            if (!wordFound) {
                res.append(s);
            }
        }

        return res.toString();
    }
}