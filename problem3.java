class TrieNode {
    TrieNode children[];
    String word;

    TrieNode() {
        children = new TrieNode[26];
    }
}

class Solution {

    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dict, String sentence) {

        for (String word : dict) {

            TrieNode curr = root;

            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }

        StringBuilder ans = new StringBuilder();

        for (String word : sentence.split("\\s+")) {

            if (word.length() > 0)
                ans.append(" ");

            TrieNode curr = root;

            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null || curr.word != null)
                    break;
                curr = curr.children[c - 'a'];
            }
            ans.append(curr.word != null ? curr.word : word);
        }
        return ans.toString().trim();
    }
}