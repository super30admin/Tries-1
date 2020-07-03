// Time Complexity : O(nlogn). n is the size of the words list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    TrieNode root;
     class TrieNode{
        String word;
        TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
     /** Inserts a word into the trie. */
    public void insert(String words) {
        TrieNode currentPtr = root;
        
        for(int i=0;i<words.length();i++){
            char currChar = words.charAt(i);
            
            if(currentPtr.children[currChar-'a']==null){
                currentPtr.children[currChar-'a']=new TrieNode();
            }
            currentPtr = currentPtr.children[currChar-'a'];
        }
        
        currentPtr.word = words;
    }
    
    public String longestWord(String[] words) {
        root = new TrieNode();
        
        for(String eachWord:words){
            insert(eachWord);
        }
        
        Queue<TrieNode> q = new LinkedList();
        q.add(root);
        
        TrieNode currNode=null;
        
        while(!q.isEmpty()){
            currNode = q.poll(); 
            
            for(int i=25;i>=0;i--){
                if(currNode.children[i]!=null && currNode.children[i].word!=null)
                    q.add(currNode.children[i]);
            }
            
        }
        return currNode.word;
    }
}
