//Accepted on LT
//Not sure with time
//Idea is simple just have a trie and go on the trie checking for boolean and if at all path we have true meaning there is a difference of 1 character than we can return

class Solution {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        Arrays.sort(words);

        String result = "";

        for (String word : words) {
            if (word.length() == 1 || searchPrefix(word.substring(0, word.length() - 1), root)) {
                insertWord(word, root);
                if (word.length() > result.length()) {
                    result = word;
                }
            }
        }

        return result;
    }

    private void insertWord(String word, TrieNode root) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    private boolean searchPrefix(String prefix, TrieNode root) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.children.containsKey(ch) || !node.children.get(ch).isEnd) {
                return false;
            }
            node = node.children.get(ch);
        }
        return true;
    }

   
}
