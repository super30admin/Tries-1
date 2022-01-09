import java.util.*;

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach
class Solution {
    
    class TrieNode {
        TrieNode[] children;
        String word;
        
        TrieNode(){
            children= new TrieNode[26];
            word="";
        }
    }
    
    TrieNode root;
    
// Time Complexity O(l) for inserting  1 word with length l, for m words- O(ml*26)
// Space Complexity :O(ml*26) for each character we have an array of 26 length and one bool variable
    private void insert(String word){        
        TrieNode curr=root;
         for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a']= new TrieNode(); 
                }
                curr=curr.children[ch-'a'];
            }
        curr.word=word;    
    }
    
// Time Complexity O(m*l*26) for for BFS
// Space Complexity :O(ml*26) maximum character in a queue
    public String longestWord(String[] words) {
        if( words==null || words.length==0)
            return "";
        root=new TrieNode();
        for(String word:words){
           insert(word);       
        }
        Queue<TrieNode> q=new LinkedList<>();
        q.add(root);
        TrieNode curr=null;
        while(!q.isEmpty()){
            curr=q.poll();
            for(int i=25;i>=0;i--){
                if((curr.children[i]!=null) && (!(curr.children[i].word).isEmpty())){
                    q.add(curr.children[i]);
                }
            }
        }
        if(curr!=root)
            return curr.word;
        else return "";
    }
}
