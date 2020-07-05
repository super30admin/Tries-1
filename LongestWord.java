package com.ds.rani.trie;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 *
 * If there is no answer, return the empty string.
 * Example 1:
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * Example 2:
 * Input:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation:
 * Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 * Note:
 *
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 */

//Approach:
//time complexity:
//space Complexity
public class LongestWord {

    //create empty root of trie
    TrieNode root = new TrieNode();

    public String longestWord(String[] words) {

        //take each word from the words and create a trie
        for (String word : words) {
            insertWordInTrie( word );
        }

        //use level order traversal to find the longest word(word is added vertically in trie)
        Queue<TrieNode> q = new LinkedList<>();
        q.add( root );
        TrieNode curr = null;
        while (!q.isEmpty()) {
            //every node can have maximum 26 children, and there could be tie in length of 2 words in that
            // case we have to pick the word which is alphabetically comes first. To solve that if i add z first and a last,
            // so z will be removed first from q and finally a wiil be removed.

            curr = q.remove();
            for (int i = 25; i >= 0; i--) {
                //if child index at i is not null and that node is the last node of that word
                if (curr.children[i] != null && curr.children[i].word != null) {
                    q.add( curr.children[i] );
                }
            }
        }

        return curr.word;
    }

    private void insertWordInTrie(String word) {
        TrieNode curr = root;
        //create a node for every character in the word
        for (char ch : word.toCharArray()) {
            //if there is no node at for ch index in its children, create it
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        //once word is added in trie for last letter of the word we will add word in trie
        curr.word = word;
    }
}

class TrieNode {
    String word;
    //max 26 children will be there for every node
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }
}