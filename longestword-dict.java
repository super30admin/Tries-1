// Time Complexity : O(n) n is length of all words in input dict
// Space Complexity : O(n) n is length of all words in input dict
// Did this code successfully run on Leetcode : Yes

class Solution {
    class TrieNode{
        String word;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;    
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }
    
    public String longestWord(String[] words) {
        if(words == null || words.length == 0)
            return "";
        root = new TrieNode();
        for(String word : words)
            insert(word);
        
        Queue<TrieNode> q = new LinkedList();
        q.add(root);
        TrieNode curr = root;
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i >=0; i--){
                if(curr.children[i] != null && curr.children[i].word != null){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }

}
