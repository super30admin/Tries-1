
import java.util.*;
class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        Set<String> preSearch;
        public TrieNode() {
            children = new TrieNode[26];
            preSearch = new HashSet<>();
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) { // Time: O(Length of the string) | Space: O(Length of the string)
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
            curr.preSearch.add(word);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) { // Time: O(Length of the string) | Space: O(Length of the string  with constant array)
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) { // Time: O(Length of the prefix) | Space:  O(1)
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++) {
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return true;
    }

    public Set<String> suggestions(String prefix) { // basically to get suggestion upon prefix
        //Time: O(length of the prefix)
        //Space: O(1)
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++) {
            char c = prefix.charAt(i);
            curr = curr.children[c-'a'];
        }
        return curr.preSearch;
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apollo");
        trie.insert("appo");
        trie.insert("appppp");
        trie.insert("banana");
        System.out.println(trie.suggestions(""));
    }
}