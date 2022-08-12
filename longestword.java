//T.C : O( average of (n)) where n is the length of words[i]
//S.C : O(average of (n)) space occupied by Trie
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    
    class TrieNode{
        TrieNode[] children;

        String str;
        
        public TrieNode(){
            children= new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public void insert(String word){
        TrieNode curr= root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']= new TrieNode();
            }
            curr=curr.children[c-'a'];
            
        }
        
        curr.str=word;
    }
    
    public String longestWord(String[] words) {
        root = new TrieNode();
        
        Queue<TrieNode> q = new LinkedList<>();
        
        for(String word:words){
            insert(word);
        }
        TrieNode curr= root;
        curr.str="";
        q.add(root);
        
        
        while(!q.isEmpty()){
            curr=q.poll();
            
            
            for(int i=25;i>=0;i--){
                if(curr.children[i]!=null && curr.children[i].str!=null){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.str;
    }
}
