import java.util.List;

public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }

        String[] inputWords = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputWords.length; i++) {
            String word = inputWords[i];
            String prefix = trie.getPrefix(word);
            if (i != 0) {
                result.append(" ");
            }
            if (prefix.isEmpty()) {
                result.append(word);
            } else {
                result.append(prefix);
            }
        }

        return result.toString();
    }

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode head = root;
            for (int i = 0; i < word.length(); i++) {
                int currChar = word.charAt(i)-'a';
                if (head.children[currChar] == null) {
                    head.children[currChar] = new TrieNode();
                }
                head = head.children[currChar];
            }
            head.isEnd = true;
        }

        public String getPrefix(String word) {
            StringBuilder prefix = new StringBuilder();
            TrieNode head = root;
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if(head.children[curr-'a'] == null || head.isEnd){
                    break;
                }
                prefix.append(curr);
                head = head.children[curr-'a'];
            }
            return head.isEnd ? prefix.toString(): "";
        }
    }
}

