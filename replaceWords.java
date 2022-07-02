
// Time Complexity : O(n)
// Space Complexity : O(ml)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

// TrieNode class implementation
class TrieNode {
    // to check end of the word
    boolean isEnd;
    // to store children
    TrieNode[] children;

    // constructor
    TrieNode() {
        // there will be 26 children at each node
        children = new TrieNode[26];
    }
}

class Main {
    // root for TriNode
    TrieNode root;

    public void insert(String word) {
        // current TrieNode
        TrieNode curr = root;
        // traverse through each character in a word and create a new child if not
        // existed
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
        // initialization of trienode
        root = new TrieNode();
        // word Array
        String[] strArray = sentence.split(" ");
        // add all the words into the Trie
        for (String d : dictionary) {
            insert(d);
        }
        // string builder to store string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            // to add a space after every word
            if (i != 0)
                sb.append(" ");
            // to make sure we found our element or not
            boolean flag = true;
            String word = strArray[i];
            // for traverse in the Trie
            TrieNode curr = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                // check if TrieNode is null we are not going further as this breaches our
                // condition
                if (curr.children[c - 'a'] == null) {
                    break;
                } else if (curr.children[c - 'a'].isEnd) {
                    // if we found end that means we found replacemenet
                    // I make flag false as this word is replaced
                    flag = false;
                    // append into string builder
                    sb.append(word.substring(0, j + 1));
                    // break as there is no need of further travresal
                    break;
                }
                // Go further in the Trie
                curr = curr.children[c - 'a'];
            }
            // if flag is true that means we havent found word in dict so we add original
            // word in string
            if (flag) {
                sb.append(word);
            }

        }
        // return result;
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        Main main = new Main();
        System.out.println(main.replaceWords(dictionary, sentence));
    }
}