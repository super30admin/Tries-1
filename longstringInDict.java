class Solution {
    
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children=new TrieNode[26];
        }
        
    }
    StringBuilder longStr;
    TrieNode  root;
    public String longestWord(String[] words) {
        root=new TrieNode();
        longStr=new StringBuilder();
        for(String word:words){
            insert(word);
        }
        
        dfs(root,new StringBuilder());
        return longStr.toString();
    
    }
    
    private void dfs(TrieNode curr,StringBuilder s ){
        //base
        if(s.length()>longStr.length())
            longStr=new StringBuilder(s);
        
        for(int i=0;i<26;i++){
            int len=s.length();
            if(curr.children[i]!=null && curr.children[i].isEnd){
                s.append((char)(i+'a'));
                //recurse
                 dfs(curr.children[i],s);
                //backtracking- setting length to previous length i.e before adding d to  worl
                s.setLength(len);
            }
        
             }
    }
    
    private void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
        char c=word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
                
                }
            curr=curr.children[c-'a'];    
            }
        curr.isEnd=true;
    }
}
