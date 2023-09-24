//                           insert         search        prefix
// Time Complexity:           O(l)           O(l)          O(p)
// Space Complexity:          O(l)           O(1)          O(1)
// where l is maximum length of word, p is maximum length of prefix
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

class TrieNode {

    TrieNode[] children;
    boolean end;

    public TrieNode() {
        children = new TrieNode[26];
        end = false;
    }

}

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.end = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
    public String getPrefixWord(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null) {
                return null;
            }
            node = node.children[c - 'a'];
            if(node.end == true) {
                return word.substring(0,i+1);
            }
        }
        return null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
