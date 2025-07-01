// TC : O(n × L)
// SC : O(n × L)
// Runs on Leetcode: YES
class Solution {
    TrieNode root;

    class TrieNode {
        Character val;
        boolean isEnd;
        TrieNode[] children;

        TrieNode(char ch) {
            this.val = ch;
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    public String longestWord(String[] words) {
        Queue<TrieNode> q = new LinkedList<>();
        Queue<String> sq = new LinkedList<>();

        root = new TrieNode(' ');

        for (String word : words) {
            insert(word);
        }

        q.add(root);
        sq.add("");

        String currentString = "";
        while(!q.isEmpty()){
            TrieNode node = q.poll();
            currentString = sq.poll();

            for(int i=25; i>=0; i--){
                if(node.children[i] != null && node.children[i].isEnd == true ){
                    q.add(node.children[i]);
                    sq.add(currentString + node.children[i].val);
                }
            }
        }

        return currentString;
    }

    private void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode(ch);
            }
            current = current.children[ch - 'a'];
        }
        current.isEnd = true;
    }

    private boolean search(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (current.children[ch - 'a'] == null) {
                return false;
            }
            current = current.children[ch - 'a'];
        }
        return current.isEnd;
    }
}