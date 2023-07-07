// Time Complexity : Insert and search -  O(l), starts with - O(length of prefix)
// Space Complexity : O(l)

 /* create a trienode array to store the characters for the words inserted and isEnd boolean to store the end point of the word. isEnd -> true means it is the end of charcter of thw word inserted
 * For search and startwith, check character by charatcter if it present, if not return false.
*/
class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.isEnd = true;

    }

    public boolean search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }

        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }

        return true;
    }
}