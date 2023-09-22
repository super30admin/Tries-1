import java.util.*;

class LongestWord {
    // TC: O(nlogn) //SC: O(n)
    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashSet<String> build = new HashSet<>();
        String result = "";
        for (String w : words) {
            if (w.length() == 1 || build.contains(w.substring(0, w.length() - 1))) {
                if (w.length() > result.length())
                    result = w;
                build.add(w);
            }
        }
        return result;
    }
}

// TC: O(l)...l= is word length // SC: O(h)... h=height of the trie
class TrieNode {
    boolean isEndOfWord; // shows end of string
    TrieNode[] children; // references to child nodes

    public TrieNode() {
        children = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(); // initialize empty tree
    }

    // method inserts word into Trie, takes word as parameter
    public void insert(String word) {
        TrieNode position = root;
        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (position.children[c - 'a'] == null) {// new char
                position.children[c - 'a'] = new TrieNode();
            }
            position = position.children[c - 'a'];
        }
        position.isEndOfWord = true;// end of the word
    }

    // method searchs word(parameter) in Trie,
    // returns true if it is there, else false
    public boolean search(String word) {
        TrieNode position = root;
        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (position.children[c - 'a'] == null) {
                return false;
            }
            position = position.children[c - 'a'];
        }
        return position.isEndOfWord;
    }

    // method checks if any string in the tree begins with the given sequence.
    public boolean startsWith(String prefix) {
        TrieNode position = root;
        char c;
        for (int i = 0; i < prefix.length(); i++) { // iterate
            c = prefix.charAt(i);
            if (position.children[c - 'a'] == null) { // miss
                return false;
            }
            position = position.children[c - 'a']; // update position
        }
        return true;
    }

    // TC: O(m*n) SC: O(m*n),
    // n is the number of words and m is the length of the word
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary);
        StringBuilder result = new StringBuilder();
        String[] splitArr = sentence.split(" ");
        for (int i = 0; i < splitArr.length; i++) {

            String word = splitArr[i];
            if (i > 0)
                result.append(" ");
            boolean flag = false;
            for (int k = 0; k < word.length(); k++) {
                String sub = word.substring(0, k + 1);
                if (flag)
                    break;
                if (set.contains(sub)) {
                    flag = true;
                    result.append(sub);
                }
            }
            if (!flag) {
                result.append(word);
            }
        }
        return result.toString();
    }
}

public class Solution {
}