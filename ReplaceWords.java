import java.util.List;

//Time Complexity: O(nl)+O(mk), dictionary of n words with length l, Sentence having m words with avg length k
//Space Complexity: O(nl), dictionary of n words with length l, Trie space

class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String word) {
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

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for (String word : dictionary) { // for every word in the dictionary, insert it into the Trie
            insert(word);
        }

        String[] splitstrings = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < splitstrings.length; i++) { // for every word in the sentence search the Trie
            if (i != 0) {
                result.append(" ");
            }
            String word = splitstrings[i];
            StringBuilder sb = new StringBuilder();
            TrieNode curr = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (curr.children[c - 'a'] == null || curr.isEnd) {
                    break;
                }
                sb.append(c);
                curr = curr.children[c - 'a'];
            }
            if (curr.isEnd) {
                result.append(sb.toString());
            } else {
                result.append(word);
            }

        }
        return result.toString();
    }

}
