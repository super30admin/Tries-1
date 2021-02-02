// Time Complexity : O(mn) m being average length of the words and n being amount of words
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    class TrieNode{
        //to hold the whole word at the end
        String word;
        TrieNode [] children;
        public TrieNode(){
            //lower case letters only
            children = new TrieNode[26];
        }
    }
    //root
    TrieNode root;
    //insert function
    private void insert(String word){
        //set cur
        TrieNode cur = root;
        //iterate through the word
        for(int i = 0; i < word.length(); i++){
            //get the letter
            char c = word.charAt(i);
            //check if the letter is there or not
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }
            //if it is there move cur pointer
            cur = cur.children[c-'a'];
        }
        //fill in the whole word at the end
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
        //add the root
        que.add(root);
        //get the cur
        TrieNode cur = root;
        //start while loop
        while(!que.isEmpty()){
            //pull out the cur
            cur = que.poll();
            //start iterating backwords from the trie children array
            for(int i = 25; i >= 0; i--){
                //check if the letter either doesn't exist or if the word is not being formed
                if(cur.children[i] != null && cur.children[i].word != null){
                    //add to the queue
                    que.add(cur.children[i]);
                }
            }
        }
        return cur.word;
    }
}

