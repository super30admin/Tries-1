// Time Complexity : O(n * W) [w: number of characters in each word; n: number of words in the array; W: ∑(w)]
// Space Complexity : O(n * W)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
     String result = "";
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }

        @Override
        public String toString() {
            return "TrieNode [isEnd=" + isEnd + ", children=" + Arrays.toString(children) + "]";
        }
    }

    class Trie {
        TrieNode parent;

        public Trie() {
            this.parent = new TrieNode();
        }

        public void insert(String word) {
            char a = 'a';
            TrieNode curr = this.parent;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (null == curr.children[ch - a]) {
                    curr.children[ch - a] = new TrieNode();
                }

                curr = curr.children[ch - a];
            }

            curr.isEnd = true;
        }
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();

        for (String str : words) {
            trie.insert(str);
        }

        dfs(trie.parent, new StringBuilder());
        return result;
    }

    private void dfs(TrieNode parent, StringBuilder sb) {
        if(parent.isEnd && sb.length() > result.length()) {
            result = sb.toString();
        }

        for(int i = 0; i < 26; i++) {
            if(parent.children[i] != null && parent.children[i].isEnd) {
                char currCh = (char) ('a' + i);
                sb.append(currCh);
                dfs(parent.children[i], sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}