class Solution {
    
    public String longestWord(String[] words) {
        if (words == null || words.length == 0)
            return "";
        Trie head = new Trie();
        Arrays.sort(words);
        for (String word : words)
            head.insert(word);
        return head.maxString;
    }
    public class Trie {
        public String maxString = "";
        public Trie[] children = new Trie[26];
        public void insert(String s) {
            Trie cur = this;
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                int idx = chs[i] - 'a';
                if (cur.children[idx] != null) {
                    cur = cur.children[idx];
                } else {
                    if (i < s.length() - 1) 
                        return;
                    cur.children[idx] = new Trie();
                    cur = cur.children[idx];
                    if (s.length() > maxString.length())
                        maxString = s;
                }
            }
        }
    }
}
