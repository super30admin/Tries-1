import java.util.*;

class Solution {

    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode('-');

        for (String word : dict) {
            insert(root, word);
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");

        for (String word : words) {
            sb.append(getRoot(root, word)).append(" ");
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public void insert(TrieNode node, String word) {
        TrieNode temp = node;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            temp.map.putIfAbsent(c, new TrieNode(c));
            temp = temp.map.get(c);
        }

        temp.isWord = true;
    }

    public String getRoot(TrieNode root, String word) {
        TrieNode temp = root;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!temp.map.containsKey(c)) {
                return word;
            }
            temp = temp.map.get(c);
            sb.append(c);
            if (temp.isWord) {
                return sb.toString();
            }
        }

        return word;
    }
}

class TrieNode {
    char c;
    Map<Character, TrieNode> map = new HashMap<>();
    boolean isWord;

    TrieNode(char c) {
        this.c = c;
    }
}
