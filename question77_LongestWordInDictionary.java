package Tries1;

import java.util.LinkedList;
import java.util.Queue;

public class question77_LongestWordInDictionary {
    /* Created by palak on 7/7/2021 */

    /*
        TC: O(n); length of the word
        SC: O(n); length of the word
    */
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    /** Initialize your data structure here. */
    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        /** Inserts a word into the Trie  */
        private void insert(String word) {
            TrieNode curr = root;
            for(int i = 0 ; i < word.length() ; i++) {
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
            curr.word = word;
        }

        public String findLongestWord() {
            String result = null;
            Queue<TrieNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0 ; i < size ; i++) {
                    TrieNode node = queue.poll();
                    for(int j = 25 ; j >= 0 ; j--) {
                        if(node.children[j] != null && node.children[j].isEnd) {
                            result = node.children[j].word;
                            queue.offer(node.children[j]);
                        }
                    }
                }
            }
            return result;
        }
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }
        return trie.findLongestWord();
    }

    public static void main(String[] args) {

    }
}
