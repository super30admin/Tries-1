//Time Complexity : O(m*n). m is the number of words and n is the average length of each word
//Space Complexity ; O(m*n). the trie takes O(m*n) and queue takes O(m) apace so the dominant part is tries space
class Solution {
    class TrieNode{
        String word;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word){
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.children[c-'a']==null){
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.word = word;//store the word for each child
    } 
    public String longestWord(String[] words) {
        if(words.length==0 || words==null){
            return "";
        }
        root = new TrieNode();
        //insert into Trie
        for(String word : words){
            insert(word);
        }
        
        Queue<TrieNode> q = new LinkedList<>();
        TrieNode curr = root;
        q.add(root);
        
        //start the BFS from right to left in order to get the right lexicographical order
        while(!q.isEmpty()){
            curr = q.poll();
            //start iterating from back for each node
            for(int i=25;i>=0;i--){
                //if the child node exists and its word is not null then add the child into queue
                if(curr.children[i]!=null && curr.children[i].word!=null){
                    q.add(curr.children[i]);
                }
            }
        }
        //the last node in the queue will have the longest word
        if(curr.word == null){
            return "";
        }
        return curr.word;
        
    }
}