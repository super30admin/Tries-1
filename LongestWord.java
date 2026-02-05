import java.util.HashMap;
import java.util.Map;

/*
Time Complexity : O(N.l) - Will need to go through all N words in the tree, assuming they have l as average length.
Space Complexity : O(C.l) - keep word(average length l) at every character node C of the trie
Did this code successfully run on Leetcode :
Any problem you faced while coding this :
Approach :

We will add all words in the trie data structure. We can keep a variable word at each node which indicates the
current word made at any particular trie node.
To find the longest word, we will need to do dfs on every child node. We can use another variable longestWord to keep track of it.
Using dfs, we will reach the end character(isEnd) of the word and get the stored word from the node, compare it with
the longest word, update the longestWord variable with the new word.
*/
public class LongestWord {
    String longestWord = "";

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        dfs(trie.root);
        return longestWord;
    }

    private void dfs(TrieNode root) {
        String result = root.word;
        if (result != null) {
            if (result.length() > longestWord.length()) {
                longestWord = result;
            }
        }
        // call dfs on all next characters at a node
        for (int i = 0; i < 26; i++) {
            TrieNode currNode = root.children[i];
            //indicates there is a character which is not the end, that is not every prefix of the word is in the trie.
            if (!currNode.isEnd) continue;
            dfs(currNode);
        }
    }

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode head = root;
            for (int i = 0; i < word.length(); i++) {
                char currChar = word.charAt(i);
                if (head.children[currChar] == null) {
                    head.children[currChar] = new TrieNode();
                }
                head = head.children[currChar];
            }
            // Keep record of the word, once it is entered in the trie
            head.word = word;
            head.isEnd = true;
        }
    }
}
