//Leetcode 720. Longest Word in Dictionary
//TTime complexity : O(nk) , n is the no of words and k is their average length.
//Space Complexity : O(nk) , n is the no of words and k is their average length.

class Solution {
       class TrieNode{
            TrieNode[] children;
            String word;
            TrieNode(){
                children = new TrieNode[26];                
            }
        }
     TrieNode root= new TrieNode();
      
    public void buildTrie(String word){
        TrieNode n= root;
        for(int i=0; i<word.length();i++){
            char c= word.charAt(i);
            if(n.children[c-'a']==null){
                
                n.children[c-'a'] = new TrieNode();
            }
            n = n.children[c-'a']; 
            
        }
        n.word= word;  
    }
    public String longestWord(String[] words) {
        
        if(words ==null || words.length ==0) return "";
        for(String w: words){
            buildTrie(w);
        }   
        Queue<TrieNode> q = new LinkedList<>();
        q.offer(root);
        TrieNode t=null;
        while(!q.isEmpty()){
              t= q.poll();
              for(int i=25;i>=0;i--){
                 if(t.children[i]!=null && t.children[i].word!=null){
                     q.offer(t.children[i]);
                 } 
              }         
        }
        
        return t.word;
        
    }
}