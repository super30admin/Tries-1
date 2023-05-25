//Leetcode - 720
//Time Complexity - n*l
//Space complexity - n*l
public class LongestWordInDictionary {
    class TrieNode {
        TrieNode [] children = new TrieNode[26];
        boolean isEnd;
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    private void insert(String word, TrieNode root) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    String longestWord;
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        this.longestWord="";
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            insert(word, root);
        }
        backtrack(root, sb);
        return longestWord;
    }
    private void backtrack(TrieNode curr, StringBuilder sb) {
        //base
        if(sb.length() > longestWord.length()) {
            longestWord = sb.toString();
        }
        //logic
        for(int i=0;i<26;i++) {
            if(curr.children[i] != null && curr.children[i].isEnd) {
                //action
                sb.append((char)('a' + i));
                //recurse
                backtrack(curr.children[i], sb);
                //backtrack
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
