/*The time complexity of this implementation is O(L) where L is the
* length of the word*/
import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert some words into the trie
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("orange");

        // Search for some words in the trie
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("banana")); // true
        System.out.println(trie.search("orange")); // true
        System.out.println(trie.search("grape")); // false

        // Check for some prefixes in the trie
        System.out.println(trie.startsWith("app")); // true
        System.out.println(trie.startsWith("ban")); // true
        System.out.println(trie.startsWith("ora")); // true
        System.out.println(trie.startsWith("gr")); // false
    }

}

