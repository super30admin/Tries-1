// Time Complexity : O(nm) + O(kl) 
// Space Complexity : O(nm) + O(k)
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            children=new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a']=new TrieNode();
            }
            curr=curr.children[ch-'a'];
        }
        curr.isEnd=true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new TrieNode();
        for(String word:dictionary){
            insert(word);
        }
        String [] sentArr=sentence.split(" ");
        StringBuilder result=new StringBuilder();
        for(int i=0;i<sentArr.length;i++){
            StringBuilder replacement=new StringBuilder();
            String word=sentArr[i];
            TrieNode curr=root;
            result.append(" ");
            for(int j=0;j<word.length();j++){
                char ch=word.charAt(j);
                if(curr.children[ch-'a']==null || curr.isEnd)
                    break;
                curr=curr.children[ch-'a'];
                replacement.append(ch);
            }
            if(curr.isEnd){
                result.append(replacement);
            }else{
                result.append(word);
            }
            
        }
        return result.toString().trim();
    }
}
