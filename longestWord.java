// Time Complexity :O(nl) n is the number of words and l is the length of the words;
// Space Complexity :O(l) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    TrieNode root;
    class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
        }
        
    }
    

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i<word.length();i++){
            if(curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        
        curr.word = word;
        
    }
    
    public String longestWord(String[] words) {
        root = new TrieNode();
        
        for(String s : words){
            insert(s);
        }
        TrieNode curr = null;
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25;i>=0;i--){
                if(curr.children[i]!=null && curr.children[i].word!=null){
                    q.add(curr.children[i]);
                }
            }
        }
        
        return curr.word;
        
    }
}