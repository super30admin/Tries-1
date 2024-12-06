// Approach: Build the Trie and apply BFS by processing the children level by level. Insert only the children with isEnd true into the Queue but  follow the lexigraphical order and then insert.
// Time : O(NL) + O(NL/2) ?? // Inserting every word to build the trie and same goes into Queue
// Space : O(NL)
class Solution {
    TrieNode root;
    class TrieNode {
        String word; // ~isEnd
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26]; // only lower case letters will be contained in the strings
        }
    }
    public void insert(String word) {
        TrieNode curr = root;
        for (int i=0;i<word.length();i++) {
            char ch =word.charAt(i);// w
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.word = word;
    }

    public String longestWord(String[] words) {
        root = new TrieNode();
        for (String word : words) {
            insert(word);// Build the Trie O(NL)
        }
        // Processing the Trie using BFS - level by level
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = null;
        while (!q.isEmpty()) {
            curr = q.poll();
            // Process the children of the curr in lexiographical order
            for (int i = 25; i >= 0; i--) {
                // check if we can add the children of that curr Trienode to Queue r not
                // conditions - have a children and if that children isWord
                if (curr.children[i] != null && curr.children[i].word != null) {
                    q.add(curr.children[i]);
                }
            }

        }
        return curr.word; // this is lexiographically better & longest string as well.
    }
}