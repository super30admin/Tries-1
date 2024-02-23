//Accepted on LT
// Same logic maintain a trie and in the trie we chekc for any word to replace if so we do
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        class TrieNode {
            TrieNode[] children;
            boolean isEnd;
        
            public TrieNode() {
                children = new TrieNode[26];
                isEnd = false;
            }
        }
        TrieNode root = new TrieNode();
        buildTrie(dictionary, root);

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");

        for (String word : words) {
            String replacement = findRoot(word, root);
            result.append(replacement).append(" ");
        }

        return result.toString().trim();
    }

    private void buildTrie(List<String> dictionary, TrieNode root) {
        for (String word : dictionary) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isEnd = true;
        }
    }

    private String findRoot(String word, TrieNode root) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();

        for (char ch : word.toCharArray()) {
            prefix.append(ch);
            if (node.children[ch - 'a'] == null) {
                return word;
            }
            node = node.children[ch - 'a'];
            if (node.isEnd) {
                return prefix.toString();
            }
        }

        return word;
    }

    
}
