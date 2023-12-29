// Time Complexity : O(order+s)
// Space Complexity : O(26) -> O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * DFS
 */
class Solution {

    TrieNode root;
    String result;

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }


    public String longestWord(String[] words) {

        this.root = new TrieNode();
        this.result = "";

        for(String word: words)
            insert(word);

        dfs(root, new StringBuilder());

        return result;
    }

    private void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    private void dfs(TrieNode root, StringBuilder path) {

        //base
        if(result.length() < path.length())
            result = path.toString();

        //logic
        TrieNode curr = root;
        for(int i=0; i<26; i++) {
            if(curr.children[i] != null && curr.children[i].isEnd) {
                int len = path.length();
                //action
                path.append((char)(i+'a'));
                //recurse
                dfs(curr.children[i], path);
                //backtrack
                path.setLength(len);
            }
        }
    }
}


/**
 * BFS
 */
/*
class Solution {

    TrieNode root;

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public String longestWord(String[] words) {

        this.root = new TrieNode();

        for(String word: words)
            insert(word);

        String path = "";
        Queue<TrieNode> q = new LinkedList<>();
        Queue<String> strQ = new LinkedList<>();

        q.add(root);
        strQ.add("");

        while(!q.isEmpty()) {
            TrieNode curr = q.poll();
            path = strQ.poll();

            for(int i=25; i>=0; i--) {
                if(curr.children[i] != null && curr.children[i].isEnd) {
                    q.add(curr.children[i]);
                    strQ.add(path + (char)(i + 'a'));
                }
            }
        }

        return path;
    }
}*/
