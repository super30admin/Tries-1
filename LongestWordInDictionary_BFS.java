//Problem 77: Longest Word in Dictionary
//Time Complexity:  O(number of words * average length of word)
//Space Complexity : O(number of words * average length of word)-> Just like Tree :O(N/2)=>O(N), all nodes can be inserted into queue; 

/*
 Can be implemented using BFS or DFS
 BFS: Use queue. Start from root, then iterate over all the 26 characters, starting from last character as we have to return lexicographically smaller one , if any charcter index is not null and has a word in it then add it to the queue.
 
 In last only one element will be left return its word.
 */
import java.util.*;
class Solution77BFS {
    class TrieNode{
        String word;
        TrieNode[] children;
        
        TrieNode(){
          children = new TrieNode[26];    
        }
    }
    TrieNode root;
    public String longestWord(String[] words) {
    
        if(words==null || words.length==0) return "";
        root = new TrieNode();
        //build tree
        for(String word:words) buildTree(word);
        
        Queue<TrieNode> q = new LinkedList<>();
        q.offer(root);
        TrieNode curr=null;
        while(!q.isEmpty()){
            
            curr = q.poll();
            
            for(int i=25;i>=0;i--){
                
                if(curr.children[i]!=null && curr.children[i].word!=null){
                    q.offer(curr.children[i]);
                }
                
            }
            
        }
        
        return curr.word;
    }
    
    private void buildTree(String word){
        
        TrieNode curr = root;
        
        for(char ch:word.toCharArray()){
           
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a'] = new TrieNode();
             }
            
            curr = curr.children[ch-'a'];
            
        }
        
        curr.word = word;
    }
    
}