// Time Complexity: O(m*n) + O(n*l)
// Space Complexity: O(m*n) + O(n*l)
class Solution {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public void insert(String word) {
        TrieNode curr = root;
        for (int i=0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        // base case
        if (dictionary == null || dictionary.size() == 0) return sentence;

        for (String word: dictionary) {
            insert(word);
        }
        String[] strArray = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i=0; i<strArray.length; i++) {
            if (i!= 0) {
                result.append(" ");
            }
            String word = strArray[i];
            StringBuilder cb = new StringBuilder();
            TrieNode curr = root;
            for (int j=0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (curr.children[ch-'a'] == null || curr.isEnd) {
                    break;
                }
                cb.append(ch);
                curr = curr.children[ch-'a'];
            }
            if (curr.isEnd) {
                result.append(cb.toString());
            } else {
                result.append(word);
            }
        }
        return result.toString();
    }
}
