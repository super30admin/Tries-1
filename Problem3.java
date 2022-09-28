import java.util.List;

// TC: O(nk + ml) n = length of dictionary, k = average length of words in dictionary, m = length of sentence, l = average length of words in sentence

class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    } TrieNode root;
     public void insert(String word) { // TC: O(L) L=length of word | SC: O(1)
        TrieNode curr = root;
        for (int i = 0; i<word.length(); i++) {
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
        for (String str : dictionary) {
            insert(str);
        }
        StringBuilder result = new StringBuilder();
        String[] strArr = sentence.split(" ");
        
        for (int k = 0; k < strArr.length; k++) {
            String word = strArr[k];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c-'a'] == null || curr.isEnd) {
                    break;
                }
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            if (curr.isEnd) {
                result.append(replacement);
            }
            else {
                result.append(word);
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}