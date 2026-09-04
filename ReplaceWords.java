//Time Complexity: O(N x l) where l is length of each word
//Space Complexity: O(M x l) where l is length of each word
class Trie {
    TrieNode root;

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String getShortestVersion(String word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return word;
            }
            sb.append(c);
            if (curr.children[c - 'a'].isEnd)
                return sb.toString();
            curr = curr.children[c - 'a'];
        }
        return word;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        //Insert all the words into the trie
        for (String word : dictionary) {
            trie.insert(word);
        }

        String[] splitArr = sentence.split("\\s+");

        for (int i = 0; i < splitArr.length; i++) {
            splitArr[i] = trie.getShortestVersion(splitArr[i]);
        }

        return String.join(" ", splitArr);
    }

}