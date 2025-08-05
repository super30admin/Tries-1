// Both BFS and DFS

// number of words = n; avg len of words = l
// TC: O(nl)
// SC: O(nl)
class Solution {
    class TrieNode {
        TrieNode children[];
        String word;

        TrieNode() {
            children = new TrieNode[26];
            word = "";
        }
    }

    TrieNode root;

    private void insert(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);

            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }

            cur = cur.children[c - 'a'];
        }
        cur.word = word;
    }


    
    public String longestWord(String[] words) {

        if (words == null || words.length == 0) {
            return "";
        }

        root = new TrieNode();

        for (String word : words) {
            insert(word);
        }

        // return bfs();

        // dfs(root);
        // return result;

        StringBuilder sb = new StringBuilder("");
        dfs(root, sb);
        return result;
    }

    // BFS - Each node store the string upto it. We need to inseet from 26 to 0 since we lexicographically smaller as the answer and the left most should 
    // be the one. Final node to come out if it is the answer. 
    
    private String bfs() {
        // Similar to trees, insert the node here and not the node's value.
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);

        TrieNode cur = root;
        while (!q.isEmpty()) {
            cur = q.poll();
            for (int i = 25; i >= 0; --i) {
                if (cur.children[i] != null && !cur.children[i].word.equals("")) {
                    q.add(cur.children[i]);
                }
            }
        }

        return cur.word;
    }

    // DFS 
    int maxLength = 0;
    String result = "";
    private void dfs(TrieNode cur) {

        if (cur.word.length() > maxLength){
            maxLength = cur.word.length();
            result = cur.word;
        }
        
        for (int i = 0; i < 26; ++i) {
            if (cur.children[i] != null && !cur.children[i].word.equals("")) {
                dfs(cur.children[i]);
            }
        }
    }

    private void dfs(TrieNode cur, StringBuilder sb) {
        if (sb.length() > maxLength){
            maxLength = sb.length();
            result = sb.toString();
        }
        
        for (int i = 0; i < 26; ++i) {
            if (cur.children[i] != null && !cur.children[i].word.equals("")) {
                sb.append((char) (i + 'a'));
                dfs(cur.children[i], sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }

}

