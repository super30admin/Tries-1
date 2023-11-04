// Time Complexity : O(L)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class TrieImplementation {
    class Trie {
        class TrieNode{
            boolean isEnd;
            TrieNode[] children;

            public TrieNode(){
                this.isEnd = false;
                this.children = new TrieNode[26];
            }
        }

        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            int strLen = word.length();
            for(int i = 0; i < strLen; i++){
                char c = word.charAt(i);
                if(cur.children[c - 'a'] == null){
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {
            if(root == null) return false;
            TrieNode cur = root;
            int strLen = word.length();
            for(int i = 0; i < strLen; i++){
                char c = word.charAt(i);
                if(cur.children[c - 'a'] == null){
                    return false;
                }
                cur = cur.children[c - 'a'];
            }

            return cur.isEnd;
        }

        public boolean startsWith(String prefix) {
            if(root == null) return false;
            TrieNode cur = root;
            int strLen = prefix.length();
            for(int i = 0; i < strLen; i++){
                char c = prefix.charAt(i);
                if(cur.children[c - 'a'] == null){
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return true;
        }
    }
}
