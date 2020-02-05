/*
Space Complexity: Space occupied by the Trie
Time Complexity: (m*n) ~ O(n) ~ Linear
where m-> number of words
      n-> length of the words
*/

class Solution {
    TrieNode root = new TrieNode();
    //create TrieNode class with its data members
    //word and children
    class TrieNode{
        String word;
        TrieNode[] children;
        //constructor
        public TrieNode(){
            children = new TrieNode[26];  
        };
    }
    
    //inserting the word in Trie
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }
    
    public String longestWord(String[] words) {
        //build Trie of words
        for(String s: words){
            insert(s);
        }
        //creating a queue to process the nodes
        Queue<TrieNode> que = new LinkedList<>();
        //add root to queue
        que.add(root);
        TrieNode curr = null;
        while(!que.isEmpty()){
            curr = que.poll();
            //to main the lexicographical order
            //iterate over th children z->a
            for(int i = 25; i>=0; i--){
                //if has children and has a word associated with it
                if(curr.children[i] != null && curr.children[i].word != null){
                    que.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}