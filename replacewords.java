//Time complexity:O(ml) m- length of sentence l-length of word
//Space complexity:O(l)
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children=new TrieNode[26];
        }
    }
    TrieNode root=new TrieNode();
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    public String replaceWords(List<String> dict, String sentence) {
        root=new TrieNode();
        for(String s:dict){
            insert(s);
        }
        StringBuilder result=new StringBuilder();
        String[] sentenceArr=sentence.split("\\s+");
        for(int i=0;i<sentenceArr.length;i++){
            if(i>0){
                result.append(" ");
            }
            String sword=sentenceArr[i];
            TrieNode curr=root;
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<sword.length();j++){
                char c=sword.charAt(j);
                if(curr.children[c-'a']==null || curr.isEnd){
                    break;
                }
                sb.append(c);
                curr=curr.children[c-'a'];
            }
            if(!curr.isEnd){
                result.append(sword);
            }
            else{
                result.append(sb.toString());
            } 
        }
        return result.toString();
    }
}