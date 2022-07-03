// Time : O(n*l)
// Space : O(n*l)

class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public void insert(String word) {
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

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;

    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        return true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for (String str : dictionary) {
            insert(str);
        }
        StringBuilder result = new StringBuilder();
        String[] arr = sentence.split(" ");
        for (int k = 0; k < arr.length; k++) {
            String word = arr[k];
            if (k != 0)
                result.append(" ");
            TrieNode curr = root;
            StringBuilder replacement = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (curr.children[c - 'a'] == null || curr.isEnd)
                    break;
                replacement.append(c);
                curr = curr.children[c - 'a'];
            }
            if (curr.isEnd) {
                result.append(replacement);
            } else {
                result.append(word);
            }
        }
        return result.toString();
    }
}