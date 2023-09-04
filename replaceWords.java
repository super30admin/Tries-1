import java.util.HashMap;
import java.util.List;

/* n = number of words in the dictionary, 
L = average length of words in the dictionary, 
m = number of words in the sentence
k = average length of words in the sentence */

// Time Complexity = O(n*L + m*k)
// Space Complexity = O(n*L + m*k)
// Did this code successfully run on Leetcode : yes

class Solution {

    // Replace words in the sentence using dictionary
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trieRoot = new TrieNode('-');
        
        // Insert each word from the dictionary into trie
        for(String word : dictionary) {
            insertIntoTrie(trieRoot, word);
        }

        StringBuilder sentenceBuilder = new StringBuilder();
        String[] sentenceWords = sentence.split(" ");

        // For each word in the sentence, get its root from the trie and append to the result
        for(String word : sentenceWords) {
            sentenceBuilder.append(findRootInTrie(trieRoot, word));
            sentenceBuilder.append(" ");
        }

        // Remove the trailing space
        sentenceBuilder.setLength(sentenceBuilder.length() - 1);

        return sentenceBuilder.toString();
    }

    // Function to insert a word into the trie
    public void insertIntoTrie(TrieNode currentNode, String word) {
        TrieNode tempNode = currentNode;

        for(int i = 0; i < word.length(); i++) {
            if(tempNode.children.containsKey(word.charAt(i))) {
                tempNode = tempNode.children.get(word.charAt(i));
            } else {
                tempNode.children.put(word.charAt(i), new TrieNode(word.charAt(i)));
                tempNode = tempNode.children.get(word.charAt(i));
            }
        }

        // Mark the end of the word in the trie
        tempNode.isEndOfWord = true;
    }

    // Function to find the root of a word in the trie
    public String findRootInTrie(TrieNode trieRoot, String word) {
        TrieNode tempNode = trieRoot;
        StringBuilder rootBuilder = new StringBuilder();

        for(int i = 0; i < word.length(); i++) {
            if(tempNode.children.containsKey(word.charAt(i))) {
                tempNode = tempNode.children.get(word.charAt(i));
                rootBuilder.append(word.charAt(i));
                
                // If we've reached the end of a word in the trie, return the root
                if(tempNode.isEndOfWord) {
                    return rootBuilder.toString();
                }
            } else {
                break;
            }
        }

        return word;
    }
}

class TrieNode {
    char value;
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode(char value) {
        this.value = value;
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
