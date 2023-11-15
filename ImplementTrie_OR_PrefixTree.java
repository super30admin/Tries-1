// TC : Insert - O(l), search - O(l), startsWith - O(l)
// SC : O(26^

package S30_Codes.Tries_1;
import java.util.HashMap;
import java.util.Map;

public class ImplementTrie_OR_PrefixTree {
}
class TrieNode{
    boolean isWord;
    Map<Character, TrieNode2> children;
    TrieNode(){
        isWord = false;
        children = new HashMap<>();
    }
}
class Trie {
    TrieNode2 root;

    public Trie() {
        root = new TrieNode2();
    }

    public void insert(String word) {
        TrieNode2 curr = root;

        for(int i=0; i<word.length(); i++){
            char childChar = word.charAt(i);
            if(!curr.children.containsKey(childChar))
                curr.children.put(childChar, new TrieNode2());
            curr = curr.children.get(childChar);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode2 node = findNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode2 node = findNode(prefix);
        return node != null;
    }

    private TrieNode2 findNode(String word){
        TrieNode2 curr = root;
        for(int i=0; i<word.length() && curr!=null; i++){
            char childChar = word.charAt(i);
            // if(!curr.children.containsKey(childChar))
            //     return null;
            curr = curr.children.get(childChar);
        }
        return curr;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */