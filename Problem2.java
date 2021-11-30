//leetcode 720: Longest word in dictionary
// Time Complexity : O(N) N is sum of lengths of words
// Space Complexity : O(NK)
class Solution {
    
    class TrieNode{
        
        TrieNode[] children;
        String word;
        
        public TrieNode(){
            children = new TrieNode[26];
            word = "";
        }
    }
    
    TrieNode root;
    
    public void insert(String word){
        
        TrieNode curr = root;
        
        for(int i = 0;i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }
    
    public String longestWord(String[] words) {
        
        root = new TrieNode();
        
        for(String word: words){
            insert(word);
        }
        
        Queue<TrieNode> q = new LinkedList();
        q.add(root);
        TrieNode curr = null;
       while(!q.isEmpty()){
            
           curr = q.poll();
           for(int i  = 25 ; i >=0; i--){
               if(curr.children[i] != null && curr.children[i].word.length() > 0){
                   q.add(curr.children[i]);
               }
           }
        }
        
        return curr.word;
    }
}