// Time Complexity : O(N) N is sum of lengths of words
// Space Complexity : O(NK)
// Any problem you faced while coding this : No

class Solution {
    class TrieNode{
        TrieNode[] children;
        String word;
        
        TrieNode(){
            this.children=new TrieNode[26];
            this.word="";
        }
    }
    
    TrieNode root;
    public void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.word=word;
    }
    
    public String longestWord(String[] words) {
        root=new TrieNode();
        for(String word:words){
            insert(word);
        }
        
        Queue<TrieNode> queue=new LinkedList<>();
        queue.add(root);
        TrieNode curr=root;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                 curr=queue.poll();
                for(int k=25;k>=0 ;k--){
                    if(curr.children[k]!=null && curr.children[k].word.length()>0){
                        queue.add(curr.children[k]);
                    }
                }    
            }
        }
        return curr.word;
    }
}