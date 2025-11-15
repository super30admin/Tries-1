import java.util.List;
/**
 * LeetCode Problem 648: Replace Words
 * https://leetcode.com/problems/replace-words/
 * Time Complexity: O(N + M) where N is the total number of characters in the dictionary and M is the number of characters in the sentence.
 * Space Complexity: O(N) for storing the Trie.
 */
public class ReplaceWords {

    private TrieNode root;

    public ReplaceWords() {
        root = new TrieNode();
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder result = new StringBuilder();
        for (String dictWord : dictionary) {
            insert(dictWord);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String dict = search(word);
            if (!dict.isEmpty())
                result.append(dict);
            else
                result.append(word);
            if (i != words.length - 1)
                result.append(" ");
        }
        return result.toString();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode child = curr.children[c - 'a'];
            if (child == null) {
                TrieNode n = new TrieNode();
                curr.children[c - 'a'] = n;
                curr = n;
            } else {
                curr = child;
            }
            if (i == word.length() - 1) {
                curr.isEnd = true;
            }
        }
    }

    public String search(String word) {
        int index = 0;
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                break;
            } else {
                curr = curr.children[c - 'a'];
                index++;
            }
            if (curr.isEnd) // return the shortest prefix found. Thats why we return here.
                return word.substring(0, index);
        }
        return "";
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    public static void main(String[] args) {
        String replaced = new ReplaceWords().replaceWords(List.of("cat", "bat", "rat"),
                "the cattle was rattled by the battery");
        System.out.println(replaced);

        replaced = new ReplaceWords().replaceWords(List.of("a", "aa", "aaa", "aaaa"),
                "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa");
        System.out.println(replaced);
    }

}
