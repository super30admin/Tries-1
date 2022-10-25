class Solution {

    class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public void insert (String word) {
        TrieNode curr = root;
        for (int i=0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) return "";

        root = new TrieNode();

        for (String word: words) {
            insert(word);
        }

        // BFS based solution
        Queue<TrieNode> q = new LinkedList<>();

        q.add(root);
        TrieNode curr = root;
        //start BFS
        while (!q.isEmpty()) {
            curr = q.poll();
            for (int j=25; j>=0; j--) {
                if(curr.children[j] !=null && curr.children[j].word != null) {
                    q.add(curr.children[j]);
                }
            }
        }
        if (curr.word == null) {
            return "";
        }
        return curr.word;
    }
}
