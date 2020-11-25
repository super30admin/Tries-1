package Nov25;

import java.util.LinkedList;
import java.util.Queue;

class LongestWordInDictionary {
    
    /*
    Time complexity: O(mn) 
    Insertion in trie DS means iterating through all the n words with an average length of m.
    Queue can have at max mn elements if every word of input array is an element in the queue.
    
    Space complexity: O(mn) where n is no.of words in input array with an average length of m.
    Because queue is additional space whose max length can be mn assuming that every word of input array is an element in the queue in worst case.

    Approach: 
    Trie DS used to hold every word of the words array. 
    Traverse from the root till leaf node to find a word. During traversal, if at every node, a word is formed => addition of one character to every word generates a new word which is also present in the input array.
    
    */
    
    // Custom class for Trie Node  
    class TrieNode {
            TrieNode[] children;
            String word;
            public TrieNode() {
                children = new TrieNode[26];
            }
    }
    
    TrieNode root;
    
    public String longestWord(String[] words) {
        
        // edge
         if (words == null || words.length == 0) {
             return "";
         }
        
        // populate each word of the words array in trie DS - O(mn)
        root = new TrieNode();
        for (String word: words) {
            insertWordInTrie(word);
        }
        
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = null;
        
        // Search till the depth using queue of trie node.
        while (!q.isEmpty()) {
            curr = q.poll();
            for (int i = 25; i >= 0; i--) {
                if (curr.children[i] != null && curr.children[i].word != null) {
                    q.add(curr.children[i]);
                }
            }   
        }
        return curr.word;
    }
    
    // helper function to insert a word in the trie DS
    private void insertWordInTrie(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (curr.children[curChar - 'a'] == null) {
                curr.children[curChar - 'a'] = new TrieNode();
            }
            curr = curr.children[curChar - 'a'];
        }
        curr.word = word;
    }
    
}