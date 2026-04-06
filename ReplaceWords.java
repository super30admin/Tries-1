// // HashSet approach, O(n * L^2) time, O(n * L) space
// class Solution {
//     public String replaceWords(List<String> dictionary, String sentence) {
//         HashSet<String> set = new HashSet<>(dictionary); // O(n * L)
//         StringBuilder ans = new StringBuilder();

//         String[] words = sentence.split(" ");

//         for (int i = 0; i < words.length; i++) {

//             if (i != 0) ans.append(" ");

//             String word = words[i];
//             boolean flag = false;

//             for (int j = 0; j < word.length(); j++) {
//                 String substring = word.substring(0, j+1);

//                 if (set.contains(substring)) {
//                     ans.append(substring);
//                     flag = true;
//                     break;
//                 }

//             }
//             if (!flag) {
//                 ans.append(word);
//             }
//         }
//         return ans.toString();
//     }
// }

// Trie approach, O(D * L + S * W) time, O(D * L) space
// D is number of words in dictionary, L is length of dictionary word, S is number of words in sentence, W is length of sentence word

import java.util.*;

class Solution {
    TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for (String word : dictionary) {
            insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i != 0) ans.append(" ");

            String word = words[i];
            ans.append(getShortestVersion(word));

        }
        return ans.toString();
    }

    private void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    private String getShortestVersion(String word) {
        TrieNode curr = root;
        StringBuilder path = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return word;
            }

            path.append(c);
            curr = curr.children[c - 'a'];

            if (curr.isEnd) return path.toString();
        }
        return word;
    }

}

class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[26];
    }
}