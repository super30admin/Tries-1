/*
Time Complexity:    O(nL) where n is no. of words and L is max length of one word
Space Complexity:   O(nL)  - max space occupied by the Trie
Passed all test cases on leetcode

Approach:
First we insert all the new possible words to the trie. Maintain a queue that adds words(trie nodes) at each level
such that the alphabet from the end are added to queue first because we need to get the output in lexicographical order.
Then return the last removed element from the Queue as the maximum length word.

*/

class Solution {
    TrieNode root;
    class TrieNode {
        String word;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String s:words) {
            insert(s);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = null;
        while(!q.isEmpty()) {
            curr = q.poll();
            for(int i=25;i>=0;i--) {
                if(curr.children[i]!=null && curr.children[i].word!=null) {
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}