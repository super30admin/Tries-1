import java.util.List;

/**
 * Time Complexity: O(m*k) + O(n*l); m is the size of dictionary and k is average size of dictionary items.
 *  n is the size of sentence and l is average length of each word in sentence
 * Space Complexity: O(m*k) + O(n*l); m is the size of dictionary and k is average size of dictionary items.
 *  n is the size of sentence and l is average length of each word in sentence
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 1. Take the dictionary and add all the words into a Trie
 * 2. Breakdown the sentence into String array and check if each word has presence in Trie or their "roots"
 * 3. If there is no presence in Trie, add the words as is to the answer.
 * 4. If there is presence in Trie, add the characters based on what is there in dictionary in an intermediate stringbuilder and then to the answer/result.
 * 5. Add a space after each word from the sentence is processed.
 * 6. Before returning the result, set the length of string builder such that the last space is ignored.
 */

public class ReplaceWords {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
    
    TrieNode root;

    /**
      Helper method to insert words into Trie/Prefix tree
    */
    private void insert(String word) {
        TrieNode curr = root;
        int i = 0;
        while (i < word.length()) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
            i++;
        }

        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode(); // instantiate root

        // Add dictionary to TrieNode
        for (String word: dictionary) {
            insert(word);
        }
        
        // get all the individual words from sentence.
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word: words) {
            // start checking for word from root node
            TrieNode curr = root;
            // intermediate string is to build any intermediate word which formed the derivative from dictionary word
            StringBuilder intermediate = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (curr.children[index] == null || curr.isEnd == true){
                    break;
                }
                intermediate.append(c);
                curr = curr.children[index];
            }

            if (curr.isEnd) {
                result.append(intermediate);
            } else {
                result.append(word);
            }
            result.append(" ");      
        }

        // remove the last space
        result.setLength(result.length() - 1);

        return result.toString();
    }

    public static void main(String[] args) {
        // Your code here
    }
}