// Time Complexity:           O(l)
// Space Complexity:          O(n)
// where l is maximum length of word, n is length of given sentence
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.List;

public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (sb.length() > 0) {
                sb.append(" ");
            }

            String prefixWord = trie.getPrefixWord(word);

            if (prefixWord == null) {
                sb.append(word);
            } else {
                sb.append(prefixWord);
            }
        }
        return sb.toString();
    }
}

class TrieNode {
    TrieNode[] children;
    boolean end;
    public TrieNode() {
        children = new TrieNode[26];
        end = false;
    }
}

class Trie {
    public TrieNode root;
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
