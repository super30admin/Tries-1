// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    class TrieNode{

        String word;
        TrieNode [] children;
        public TrieNode(){
            //lower case letters only
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    private void insert(String word){

        TrieNode cur = root;
        //iterate through the word
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            //check if letter is present
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }
            //move cur
            cur = cur.children[c-'a'];
        }

        cur.word = word;
    }
    public String longestWord(String[] words) {
        //edge
        if(words == null || words.length == 0) return "";
        //initialize the root
        root = new TrieNode();
        //start adding the words into the trie
        for(String w : words){
            insert(w);
        }
        //make a queue for the bfs method
        Queue<TrieNode> que = new LinkedList<>();
        que.add(root);
        TrieNode cur = root;

        while(!que.isEmpty()){
            cur = que.poll();
            //iterate backwords from the trie children
            for(int i = 25; i >= 0; i--){
                if(cur.children[i] != null && cur.children[i].word != null){
                    //add to the queue
                    que.add(cur.children[i]);
                }
            }
        }
        return cur.word;
    }
}