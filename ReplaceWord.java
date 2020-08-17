//Time Complexity O(nk+lk)
//Space Complexity O(lk) 
class Solution {
    class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }
    public String replaceWords(List < String > dict, String sentence) {
        for (String word: dict) {//nk time
            insert(word);
        }
        StringBuilder sb = new StringBuilder();
        String[] sentenceArr = sentence.split("\\s+");
        for (int i = 0; i < sentenceArr.length; i++) {//lk time
            String word = sentenceArr[i];
            if (i > 0) sb.append(" ");
            TrieNode curr = root;
            for (int k = 0; k < word.length(); k++) {
                char c = word.charAt(k);
                if (curr.children[c - 'a'] == null || curr.word != null) break;
                curr = curr.children[c - 'a'];
            }
            String replacement;
            if (curr.word == null) {
                replacement = word;
            } else {
                replacement = curr.word;
            }
            sb.append(replacement);
        }
        return sb.toString();
    }
}