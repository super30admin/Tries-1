/*
* Approach:
*  1. Insert the dictionary into trie and search each word in trie.
        Create TrieNode with isEnd and children(Array of TrieNode).
        Start with root.
* 
*  2. Insert the word into trie, by iterating over word.
        create a new node at the given char index of root and 
            proceed to next root.
*   
*  3. Replace word: find the shortest prefix of the word in trie,
        while traversing trie, 
            if any of the children is null, proceed to next word.
            if not check whether isEnd is true, if true, return shortest word.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n*k) + O(m*k)
    n - words
    m - words in sentence
    k - max length of word
* 
* Space Complexity: O(n*k)
* 
*/

import java.util.List;

public class ReplaceWord {
    class TrieNode {
        boolean isEnd;

        TrieNode[] children;

        public TrieNode() {
            this.isEnd = false;
            children = new TrieNode[26];
        }
    };

    TrieNode root;

    private void insertIntoTrie(String word) {
        TrieNode curr = root;

        for (int index = 0; index < word.length(); index++) {
            char ch = word.charAt(index);

            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new TrieNode();

            curr = curr.children[ch - 'a'];
        }

        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();

        for (String word : dictionary) {
            insertIntoTrie(word);
        }

        String[] strArray = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for (int index = 0; index < strArray.length; index++) {
            String word = strArray[index];

            if (index > 0)
                result.append(" ");

            StringBuilder replacementStr = new StringBuilder();

            TrieNode curr = root;

            for (int k = 0; k < word.length(); k++) {
                char ch = word.charAt(k);

                if (curr.children[ch - 'a'] == null || curr.isEnd)
                    break;

                replacementStr.append(ch);
                curr = curr.children[ch - 'a'];
            }

            if (curr.isEnd)
                result.append(replacementStr);
            else
                result.append(word);
        }

        return result.toString();
    }
}