//Time complexity:O(mn+kl)
//Space complexity:O(mn)
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            isEnd=false;
            children= new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word){
        TrieNode curr= root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']= new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd= true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root= new TrieNode();
        for(String s: dictionary){
            insert(s);
        }
        String[] strArray= sentence.split("\\s+");
        String res= "";
        
        for(int i=0;i<strArray.length;i++){
            if(i>0) res=res+" ";
            String str = strArray[i];
            TrieNode curr= root;
            String replace ="";
            for(int j=0;j<str.length();j++){
                char c =str.charAt(j);
                if(curr.children[c-'a']==null || curr.isEnd==true){
                    break;
                }
                replace=replace +c;
                curr=curr.children[c-'a'];
            }
            if(curr.isEnd){
                res=res+replace;
            }
            else{
                res=res+str;
            }
        }
        return res;
    }
}