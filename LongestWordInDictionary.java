// Time Complexity : O(n) where n is the longest word in Trie.
// Space Complexity : O(n) where n is the longest word in Trie.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Insert all the words in a Trie
//BFS on the trie will give us the longest word.


class Solution {
    public String longestWord(String[] words) {
        if(words == null || words.length == 0) return "";
        Trie t = new Trie();
        for(String word : words) {
            t.insert(word);
        }


        TrieNode cur = root;
        Queue<TrieNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int i = 25; i >= 0; i--) { //Reverse direction will give us lexographically smallest element, if there are more than one longest words
                if(cur.children[i] != null && cur.children[i].bEnd == true) { //Add children only if they are also end nodes
                    q.add(cur.children[i]);
                }
            }
        }
        return cur.word;
    }

    class TrieNode {
            TrieNode[] children;
            boolean bEnd;
            String word =  "";
            TrieNode() {
                children = new TrieNode[26];
                bEnd = false;
            }
    }

    TrieNode root;
    class Trie {
        public Trie() {
            root = new TrieNode();
            root.bEnd = true;
        }
        public void insert(String word) {
            TrieNode cur = root;
            for(char c : word.toCharArray()) {
                if(cur.children[c-'a'] == null) {
                    cur.children[c-'a'] = new TrieNode();
                }
                cur = cur.children[c-'a'];
            }
            cur.bEnd = true;
            cur.word = word;
        }
    }
}
