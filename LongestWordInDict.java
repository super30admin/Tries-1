// Time: O(NK) | Space: O(1)
// BFS - we find the longest string upon going through the trie node,
// DFS - we build the longest string upon characters on tries, backtrack and explore all the options

//BFS
class Solution {
    class TrieNode {
        TrieNode[] children;
        String word;
        boolean isEnd;
        public TrieNode() {
            word = "";
            children = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();
    public void insert(String word) { // Time: O(Length of the string) | Space: O(Length of the string)
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
        curr.isEnd = true;
    }
    public String longestWord(String[] words) {
        for(String word: words) {
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode trie = root;
        while(!q.isEmpty()) {
            trie = q.poll();
            for(int i=25;i>=0;i--) {
                if(trie.children[i] != null && trie.children[i].isEnd) {
                    q.add(trie.children[i]);
                }
            }
        }
        return trie.word;
    }
}

//DFS
class Solution {
    class TrieNode {
        TrieNode[] children;
        char currChar;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();
    public void insert(String word) { // Time: O(Length of the string) | Space: O(Length of the string)
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr.children[c-'a'].currChar = c;
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    StringBuilder res;
    public String longestWord(String[] words) {
        res = new StringBuilder();
        for(String word: words) {
            insert(word);
        }
        helper(root, new StringBuilder());
        return res.toString();
    }
    private void helper(TrieNode root, StringBuilder currPath) {
        if(currPath.length() > res.length()){
            res = new StringBuilder(currPath);
        }
        for(int i = 0;i<root.children.length;i++) {
            if(root.children[i] != null && root.children[i].isEnd) {
                currPath.append(root.children[i].currChar);
                helper(root.children[i], currPath);
                currPath.setLength(currPath.length()-1);
            }
        }
    }
}