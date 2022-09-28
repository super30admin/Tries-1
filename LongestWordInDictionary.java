// Time Complexity :O(nk)
// Space Complexity : O(nk)
// n is the number of words in dictionary
// k is the avg length of each word in dictionary
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//DFS Arroach
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        char ch;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
            curr.ch = c;
        }
        curr.isEnd = true;
    }

    String result;

    public String longestWord(String[] words) {
        result = "";
        root = new TrieNode();

        //insert words from dictionary to Trie
        for(String word : words){
            insert(word);
        }

        backtrack(root,new StringBuilder());
        return result;
    }

    private void backtrack(TrieNode root , StringBuilder path){
        //base case
        if(path.length() > result.length()){
            result = path.toString();
        }

        //logic
        for(int i = 0 ; i < 26 ; i++){
            if(root.children[i] != null && root.children[i].isEnd){
                //action
                path.append(root.children[i].ch);
                //recursion
                backtrack(root.children[i],path);
                //backttrack
                path.setLength(path.length()-1);
            }
        }
    }
}

//BFS Approach
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        String word;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.word = "";
        }
    }

    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
        curr.word = word;
    }

    public String longestWord(String[] words) {
        root = new TrieNode();

        //insert words from dictionary to Trie
        for(String word : words){
            insert(word);
        }

        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);

        TrieNode curr = null;

        while(!q.isEmpty()){
            curr = q.poll();
            //logic
            for(int i = 25 ; i >= 0 ; i--){
                if(curr.children[i] != null && curr.children[i].isEnd){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}