
/**
 * Time Complexity: O(n*l), where is the number of words and l the average length of words
 * Space Complexity:  O(n*l), where is the number of words and l the average length of words
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None
 *
 * Approach:
 * 1. First insert all words into Trie
 * 2. Recursively build words from the Trie by going over each index among 26 possible characters (small characters is the constraint) 
 * 3. return the result
 */

public class LongestWordInDictionary {

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
     * Helper method to insert words into Trie
     * @param word
     */
    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    /**
     * Recursively look for all the words that can be possibly made from the trie nodes and add the longest word to result.
     * Since the array is traversed from a to z, it will ensure the lexicographical order is maintained
     * @param curr
     * @param sb
     */
    private void searchlongest(TrieNode curr, StringBuilder sb) {
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null && curr.children[i].isEnd == true) {
                char value = (char) (i + 'a');
                 //Action:  Append the character to the StringBuilder
                sb.append(value);

                // Update the longest word found if a longer word can be formed
                if (sb.length() > result.length()) {
                    result = sb.toString(); 
                }

                 // Recure: Recursively search the next node
                searchlongest(curr.children[i], sb);

                // Backtrack
                sb.deleteCharAt(sb.length() - 1); 
            }
        }
    }

    // to store the final result
    String result = "";

    public String longestWord(String[] words) {
        root = new TrieNode();

        // insert all the words in Trie
        for (String word : words) {
            insert(word);
        }

        // look for the longest word while intermediately forming strings from prefixes
        searchlongest(root, new StringBuilder());
        return result;

    }

    public static void main(String[] args) {
        // Your code here
    }
}
