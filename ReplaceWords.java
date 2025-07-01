// Time Complexity O(m) m=words in sentance
// Space Complexity O(n x L) n = words in dictionary, L = len of word in dictionary
// Runs on LeetCode YES

class Solution {
    TrieNode root;

    class TrieNode {
        Character val;
        boolean isEnd;
        TrieNode[] children;

        TrieNode(char ch) {
            this.val = ch;
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode(' ');
        for (String word : dictionary) {
            insert(word);
        }

        String[] words = sentence.split(" ");

        for (int j = 0; j < words.length; j++) {
            TrieNode current = root;
            String word = words[j];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (current.children[ch - 'a'] == null || current.isEnd) {
                    break;
                }

                sb.append(ch);
                current = current.children[ch - 'a'];
            }
            if (current.isEnd) {
                words[j] = sb.toString();
            }

        }

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word);
            result.append(" ");
        }

        return result.toString().trim();
    }

    private void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode(ch);
            }
            current = current.children[ch - 'a'];
        }
        current.isEnd = true;
    }
}