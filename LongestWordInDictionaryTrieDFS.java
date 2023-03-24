class Solution {

    public String result = "";

    class Trie {
        class Node {
            Node[] children;
            String word;

            Node() {
                children = new Node[26];
                word = null;
            }
        }

        Node root;

        Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node curr = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }

        public void dfs(Node node) {
            if(node == null) {
                return;
            }
            if(node.word != null) {
                if(node.word.length() > result.length()) {
                    result = node.word;
                } else if(node.word.length() == result.length() && node.word.compareTo(result) < 0) {
                    result = node.word;
                }
            }

            for(Node child : node.children) {
                if(child != null && child.word != null) {
                    dfs(child);
                }
            }
        }
    }
    public String longestWord(String[] words) {
        if(words == null || words.length == 0) {
            return null;
        }

        Trie trie = new Trie();

        for(String word : words) {
            trie.insert(word);
        }

        trie.dfs(trie.root);

        return result;
    }


}