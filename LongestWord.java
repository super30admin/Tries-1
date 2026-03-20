class Solution {
    TrieNode root;
    String ans = "";
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    // Time complexity: O(n * l)
    // Space complexity: O(n * l)
    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }
    // Time complexity: O(n * l)
    // Space complexity: O(n * l)
    public String longestWord(String[] words) {

        int max = 0;
        root = new TrieNode();
        // first insert all words O(n * l)
        for (String word: words) {
            insert(word);
        }
        // then find longest starting with the root node and empty string
        dfs(root,"");
        return ans;
    }

    public void dfs(TrieNode node, String str) {
        for (int i = 0; i < 26; i++) {

            //take the longer string and continue if the child is end
            ans = ans.length() < str.length() ? str : ans;
            if(node.children[i] != null &&  node.children[i].isEnd) {
                dfs(node.children[i], str + ((char)(i + 'a')));
            }
        }
    }

}