// Time Complexity : O(n * k) where n = no of words and k = avg length of each word
	
// Space Complexity : O(n * k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We build a Trie and put all words of dictionary into Trie.
 * Now we run a reverse bfs on trie and take the word which comes out last. 
 * This word will have longest length and it is lexicographically smaller among words of simialr length 
*/


class Solution {
    class TrieNode{
        TrieNode[] child;
        boolean isPresent;
        String word;
        
        public TrieNode(){
            child = new TrieNode[26];
        }
    }
    
    TrieNode root;
    StringBuilder ans;
    
    private void insert(String word){
        TrieNode curr = root;
        
        for(int i = 0; i < word.length();i++){
            char ch = word.charAt(i);
            if(curr.child[ch - 'a'] == null){
                curr.child[ch - 'a'] = new TrieNode();
            }
            curr = curr.child[ch - 'a'];
        }
        
        curr.isPresent = true;
        curr.word = word;
    }
    
    private void search(String s){
        TrieNode curr = root;
        
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            
            if(curr.child[ch - 'a'] == null || curr.child[ch - 'a'].isPresent == false){
                return;
            }
            
            curr = curr.child[ch - 'a'];
        }
        
         if(ans.toString().length() < s.length()){
            ans.setLength(0);
            ans.append(s);
         }else{
            if(ans.toString().length() == s.length()){
                if(ans.toString().compareTo(s) > 0){
                    ans.setLength(0);
                    ans.append(s);
                }
            }
        }
    }
    
    public String longestWord(String[] words) {
       
        ans = new StringBuilder();
        root = new TrieNode();
        
        for(String s : words){
            insert(s);
        }
        
//      for(String s : words){
//          search(s);
//      }
        
//      return ans.toString();
        
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        
        TrieNode curr = root;
        
        while(q.isEmpty() == false){
            curr = q.poll();
            
            for(int i = curr.child.length-1; i >= 0; i--){
                if(curr.child[i] != null && curr.child[i].word != null){
                    q.add(curr.child[i]);
                }
            }
        }
        
        if(curr.word == null)return "";
        return curr.word;
    }
}