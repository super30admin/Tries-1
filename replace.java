class Solution {
    TrieNode root;
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            children=new TrieNode[26];
            isEnd=false;
        }
    }
    private void insert(String word){
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null){
            curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root=new TrieNode();
        for(String w:dictionary){
            insert(w);
        }
        StringBuilder res=new StringBuilder();
        String[] split=sentence.split(" ");
        for(int i=0;i<split.length;i++){
            if(i>0)res.append(" ");
            res.append(shorter(split[i]));
        }
return res.toString();
    }
    private String shorter(String s){
        TrieNode curr=root;
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(curr.children[c-'a']==null || curr.isEnd){
                break;
            }
          sb.append(c);
            curr=curr.children[c-'a'];
        }
        if(curr.isEnd){
            return sb.toString();
        }
        return s;
    }
}