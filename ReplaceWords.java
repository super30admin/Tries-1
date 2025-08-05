// m - avg len of dic word. num of dic words = k
// n - avg len of word in sentence word. num of words in sentence = l

// TC and SC: O(m*k + nl)
class Solution {

    class TrieNode {
        TrieNode children[];
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;

    private void insert(String s) {
        TrieNode cur = root;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }

        cur.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        if (sentence == null || sentence.length() == 0) {
            return "";
        }

        if (dictionary == null || dictionary.size() == 0) {
            return sentence;
        }

        root = new TrieNode();

        for (String word: dictionary) {
            insert(word);
        }

        StringBuilder result = new StringBuilder();

        String[] strArray = sentence.split(" ");

        for (String word : strArray) {
            result.append(findRoot(word)).append(" ");
        }

        result.setLength(result.length() - 1);

        return result.toString();
    }

    private String findRoot(String word) {
        StringBuilder prefix = new StringBuilder();
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                break;
            }
            cur = cur.children[c - 'a'];
            prefix.append(c);
            if (cur.isEnd) {
                return prefix.toString();
            }

        }
        return word;
    }
}