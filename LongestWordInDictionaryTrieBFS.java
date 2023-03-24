class Solution {
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
            for(char c : word.toCharArray()) {
                if(curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }
    }
    public String longestWord(String[] words) {
        if(words == null ||words.length == 0) {
            return null;
        }
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }
        Queue<Trie.Node> q = new LinkedList<>();
        q.add(trie.root);
        Trie.Node curr = trie.root;
        while(!q.isEmpty()) {
            curr = q.poll();
            for(int i = 25; i >= 0; i--) {
                if(curr.children[i] != null && curr.children[i].word != null) {
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word == null ? "" : curr.word;
    }
}