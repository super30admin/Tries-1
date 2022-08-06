//TimeComplexity: O(nl) where, n is the word length in Trie, l is the total no. of words in trie
//As in the worst case we loop through words in Trie and words in the sentense

//SpaceComplexity: O(nl) where n is the word length and l is the total no. of words in the Trie
//As we only store the Dictionary words in Trie

import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        // at the end of each node in the trie, store that word, istead of regular isEnd
        // boolean
        curr.word = word;
    }

    // Doing a bfs on Trie
    public String longestWord(String[] words) {
        root = new TrieNode();
        // Insert all the words in the dictionary into Trie
        for (String eachWord : words) {
            insert(eachWord);
        }

        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = root;
        // Until the queue is empty parse and the last node int the queueu is the
        // required longest word
        while (!q.isEmpty()) {
            curr = q.poll();
            // parse from backside of childeren nodes,so that we'll get lecographical
            // longest word
            for (int i = 25; i >= 0; i--) {
                // for each childeren if the word at the end of the trie node is found, add it
                // into the queue
                if (curr.children[i] != null && curr.children[i].word != null) {
                    q.add(curr.children[i]);
                }
            }
        }

        // if no word is found, if only root is there in the queue then return empty
        // string
        if (curr.word == null)
            return "";

        return curr.word;

    }
}