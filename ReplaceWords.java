
//TimeComplexity: O(nl + mk) where, n is the word length in Trie, l is the total no. of words in trie
//m is the word length in the Sentence, k is the total no. of words in the sentence
//As in the worst case we loop through words in Trie and words in the sentense

//SpaceComplexity: O(nl) where n is the word length and l is the total no. of words in the Trie
//As we only store the Dictionary words in Trie

import java.util.*;

class replaceWords {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    // Creating a Trie DataStructure
    // As only small letters are allowed, creating Trie Size of 26 Length
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();

        // Calling and Creating Trie with the Dictionary
        for (String word : dictionary) {
            insert(word);
        }

        String[] wordsInSentence = sentence.split(" ");
        StringBuilder resultSB = new StringBuilder(); // Creating a StringBuilder to append the words

        // Iterating for each word in the Sentence to check if a root word of that
        // exists in Trie
        for (int i = 0; i < wordsInSentence.length; i++) {
            if (i != 0) {// creating spacing while reforming the sentence back again
                resultSB.append(" ");
            }
            TrieNode curr = root;
            StringBuilder internalSB = new StringBuilder();// Creating another stringBuilder for individual words to
                                                           // append the root if found, else append common word
            String sentenceWord = wordsInSentence[i];
            for (int j = 0; j < sentenceWord.length(); j++) {// Looping on Trie for each character in the given word
                char c = sentenceWord.charAt(j);
                if (curr.children[c - 'a'] == null || curr.isEnd) {
                    break;
                }
                internalSB.append(c);
                curr = curr.children[c - 'a'];
            }
            if (curr.isEnd) { // If the root found then append it to result StringBuilder
                resultSB.append(internalSB.toString());
                continue;
            }
            // If root not found, just append the original word
            resultSB.append(sentenceWord);
        }
        // Return the reformed sentence
        return resultSB.toString();

    }
}