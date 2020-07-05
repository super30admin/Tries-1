package com.ds.rani.trie;

import java.util.List;

/**
 *
 */

//Approach: create trie of the dictionary words, then take each word from sentence and serch if prefix exists in the
// trie, if it is exists than add prefix to result else add original word, do this process for ll the words in sentence.

//Time complexity:o(nk+lk) where n -number of words in dictionary, k-average length of each dictionary word
// l- number of words in sentence

//space Complexity
public class ReplaceWords {

    class TrieNode {
        String word;
        //max 26 children will be there for every node
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    //create root
    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dict, String sentence) {

        //insert dictionary words in trie
        for (String word : dict)//n*k
            insertWordInTrie( word );

        //now take each word from sentenece and serach its prefix in trie
        String[] sWords = sentence.split( "\\s+" );
        StringBuilder sb = new StringBuilder();
        for (String w : sWords) {
            TrieNode curr = root;
            for (int i = 0; i < w.length(); i++) {//lk
                char ch = w.charAt( i );
                //curr character not exist in trie or we found the prefix so break it
                if (curr.children[ch - 'a'] == null || curr.word != null)
                    break;
                else
                    curr = curr.children[ch - 'a'];

            }
            if (curr.word == null)
                sb.append( w );
            else
                sb.append( curr.word );
            sb.append( " " );
        }
        return sb.toString().trim();
    }

    private void insertWordInTrie(String word) {
        TrieNode curr = root;

        //create a node for every character in the word
        for (char ch : word.toCharArray()) {
            //if there is no node at for ch index in its childern create it
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        //once word is added in trie for last letter of the word we will add word in trie
        curr.word = word;
    }
}
