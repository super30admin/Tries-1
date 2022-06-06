
class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return dfs(trie.getRoot());
    }
    String dfs(TrieNode root) {
        String longest = "";
        Stack<TrieNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TrieNode node = stack.pop();
            if (node == null) continue;
            if (node.isEnd == true || node == root) {
                if (node != root) {
                    if (node.word.length() > longest.length() ||
                            (node.word.length() == longest.length() && node.word.compareTo(longest) < 0)) {
                        longest = node.word;
                    }
                }
                for (TrieNode child: node.children) {
                    stack.push(child);
                }
            }
        }
        return longest;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode node = root;
        char[] charArray = word.toCharArray();
        for (char ch : charArray) {
            if (!node.contains(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.isEnd = true;
        node.word = word;
    }

    public TrieNode getRoot() {
        return root;
    }
}
class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    String word;
    public TrieNode () {
        children = new TrieNode[26];
    }
    boolean contains(char ch) {
        return children[ch - 'a'] != null;
    }
    TrieNode get(char ch) {
        return children[ch - 'a'];
    }
    void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }
