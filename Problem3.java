import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    //TC : O(mn + lk)
    //sc : O(mn + lk)
    // where m = length of each word in dictionary, n = total word in dictionary
    // where l = length of sentence , k = each word after trimming with space
    public String replaceWords(List<String> dictionary, String sentence) {
        if (dictionary == null) return sentence;

        root = new TrieNode();
        StringBuilder result = new StringBuilder();
        for (String s : dictionary) {
            if (s != null) {
                insert(s);
            }
        }
        String[] splitArray = sentence.split(" ");

        for (String word : splitArray) {
            result.append(search(word));
            result.append(" ");
        }
        return result.toString().trim();
    }

    private String search(String word) {
        TrieNode curr = root;
        StringBuilder dict = new StringBuilder();
        for (int j = 0; j < word.length(); j++) {
            char c = word.charAt(j);
            if (curr.children[c - 'a'] == null) {
                return word;
            }
            dict.append(word.charAt(j));
            curr = curr.children[c - 'a'];
            if (curr.isEnd == true) {
                return dict.toString();
            }
        }
        return word;
    }

    private void insert(String word) {
        TrieNode curr = root;
//        String word = dictionary.get(i);
        for (int j = 0; j < word.length(); j++) {
            char c = word.charAt(j);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        String result = problem3.replaceWords(dictionary, sentence);
        System.out.println("Final result " + result);
    }
}
