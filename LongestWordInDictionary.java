import java.util.*;

public class LongestWordInDictionary {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        String word;
        TrieNode() {
            children = new TrieNode[26];
            word = "";
        }
    }

    private TrieNode root;

    private void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int indexOfChar = word.charAt(i) - 'a';
            if (current.children[indexOfChar] == null) {
                current.children[indexOfChar] = new TrieNode();
            }
            current = current.children[indexOfChar];
        }
        current.word = word;
        current.isEnd = true;
    }

    public String longestWord(String[] words) {
        if (words == null || words.length == 0)
            return "";
        root = new TrieNode();
        StringBuilder result = new StringBuilder();
        // Insert the words inside tries
        for (String word : words) {
            insert(word);
        }
        // BFS
        return BFS(words, result).toString();
    }

    private StringBuilder BFS(String[] words, StringBuilder result) {
        Queue<TrieNode> queue = new LinkedList();
        queue.add(root);
        TrieNode currentNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            for(int i=26-1;i>=0;i--) {
                if(currentNode.children[i] != null && currentNode.children[i].isEnd){
                    queue.add(currentNode.children[i]);  
                }
            }
        }
        return new StringBuilder(currentNode.word);
    }

    public static void main(String[] args) {
        LongestWordInDictionary longestWordInDictionary = new LongestWordInDictionary();
        String result = longestWordInDictionary.longestWord(new String[] { "a","banana","app","appl","ap","apply","apple"});
        System.out.println("The result is " + result);
    }
}
