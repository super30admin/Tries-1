// Time complexity - O(nl + n), nl = for insertion in trie and n = queue
// Space complexity - O(nl) , n = number of words, l = avg length of string

class Solution {
    class TrieNode{
        boolean isEnd;
         String word;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
        curr.word  = word;
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String w : words){
            insert(w);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = null;
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i >=0 ; i--){
                if(curr.children[i] != null && curr.children[i].isEnd){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}
