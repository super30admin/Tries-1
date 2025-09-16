// Time Complexity : O(N*l) where N is number of words and l is length of longest word)
// Space Complexity : O(n*l) for trie, queues and recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// After inserting all the words in a trie, we can DFS or BFS to find the longest word
// In DFS, we recursively call all the children of node which are the end of a word. Since it goes in lexical order, we replace only if the length is greater
// In BFS, we main 2 queues, one for nodes and one for path string. We iterate in reverse order so that the last word to come out of the queue is lexically largest

class Solution {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    public void insert(TrieNode root, String word) {
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new TrieNode();
                } 
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
    }

    private void dfs(TrieNode root, StringBuilder path){

        if(path.length() >= maxString.length())
            maxString = path.toString();

        for(int i=0;i<26;i++){
            int l = path.length();
            if(root.children[i] != null && root.children[i].isEnd){
                path.append((char)(i+97));
                dfs(root.children[i], path);
                path.setLength(l);
            }
        }
    }

    String maxString = "";
    public String longestWordDFS(String[] words) {

        TrieNode root= new TrieNode();
        for(String str: words){
            insert(root, str);
        }
        dfs(root, new StringBuilder());
        return maxString;
    }

    public String longestWordBFS(String[] words) {

        TrieNode root= new TrieNode();
        for(String str: words){
            insert(root, str);
        }

        Queue<TrieNode> q = new LinkedList(); 
        Queue<String> sq = new LinkedList();
        q.add(root);
        sq.add("");
        String curStr = "";

        while(!q.isEmpty()){
            TrieNode cur = q.poll();
            curStr = sq.poll();

            for(int i=25; i>=0; i--){
                if(cur.children[i] != null && cur.children[i].isEnd){
                    q.add(cur.children[i]);
                    sq.add(curStr + (char)(i+97));
                }
            }
        }

        return curStr;
    }
}