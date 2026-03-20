
// Ran on leetcode succesfully: yes
class Solution {


    TrieNode root;
    class TrieNode {
        TrieNode children [];
        boolean isEnd;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    // Time complexity: O(l)
    // Space complexity: O(l)
    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }
    // Time complexity: O(l)
    private String findShortest(String str) {

        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (curr.isEnd) return sb.toString();
            if (curr.children[str.charAt(i) - 'a'] == null) {
                return str;
            }
            sb.append(str.charAt(i));
            curr = curr.children[str.charAt(i) - 'a'];
        }
        return str;

    }
    // Time complexity: O(n * l)
    // Space complexity: O(n * l)
    public String replaceWords(List<String> dictionary, String sentence) {
        String [] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        root = new TrieNode();

        for (String st : dictionary) {
            insert(st);
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) sb.append(" ");
            sb.append(findShortest(arr[i]));
        }
        return sb.toString();



    }
}