//Time Complexity O(nk)
//Space Complexity O(nk)
Works on LeetCode : Yes

Approach is create a Trie and then perform BFS on the Trie to get the longest word.


class Solution {
    class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }
    public String longestWord(String[] words) {
        for(String w: words){
            insert(w);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = null;
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i >=0; i--){ // To get the result in lexographical order.
                if(curr.children[i] != null && curr.children[i].word != null){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}