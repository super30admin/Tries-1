// Time complexity : O(m+n)*len
// Space complexity : O(26*len)
public class LongestWordInDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    String result;

    public String longestWord(String[] words) {
        if (words == null || words.length == 0)
            return "";
        this.root = new TrieNode();
        result = "";
        for (String word : words) {
            insert(word);
        }
        helper(root, new StringBuilder());
        return result;

    }

    private void helper(TrieNode curr, StringBuilder sb) {
        // base
        if (sb.length() > result.length()) {
            result = sb.toString();
        }
        for (int i = 0; i < 26; i++) {
            int len = sb.length();
            if (curr.children[i] != null && curr.children[i].isEnd) {
                System.out.println(i);
                sb.append((char) (i + 'a'));
                helper(curr.children[i], sb);
                sb.setLength(len);
            }
        }
    }

}
