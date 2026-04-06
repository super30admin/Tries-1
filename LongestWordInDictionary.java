// Trie + BFS O(n * L) time, O(n * L) space

import java.util.*;

class Solution {
    
    String ans;
    TrieNode root;

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word){
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String longestWord(String[] words) {
        this.root = new TrieNode();
        for (String word: words) {
            insert(word);
        }

        bfs(root);

        return ans;
    }

    private void bfs(TrieNode curr) {
     
        String currStr = "";

        Queue<TrieNode> q = new LinkedList<>();
        Queue<String> strQ = new LinkedList<>();

        q.offer(root);
        strQ.offer(currStr);
       
        while (!q.isEmpty()) {
            curr = q.poll();
            currStr = strQ.poll();

            for (int i = 25; i >= 0; i--) {
                if (curr.children[i] != null && curr.children[i].isEnd) {
                    q.offer(curr.children[i]);
                    strQ.offer(currStr + (char)(i + 'a'));
                }
            }
        }

        ans = currStr;
    }
}