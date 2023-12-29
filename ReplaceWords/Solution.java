// Time Complexity : O(N) where N is the length of the sentence
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {

    TrieNode root;

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        this.root = new TrieNode();
        for(String word: dictionary)
            insert(word);

        String[] strSplit = sentence.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<strSplit.length; i++) {
            if(i != 0)
                sb.append(" ");
            sb.append(search(strSplit[i]));
        }
        return sb.toString();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    private String search(String word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null || curr.isEnd)
                break;
            sb.append(c);
            curr = curr.children[c-'a'];
        }
        if(curr.isEnd)
            return sb.toString();
        else
            return word;
    }
}