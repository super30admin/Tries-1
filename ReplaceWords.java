//Time Complexity=O(m*l+n*l)
//Space Complexity=O(n*1)
public class ReplaceWords {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children=new TrieNode[26];
        }
    }
    TrieNode root=new TrieNode();
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
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String str:dictionary){
            insert(str);
        }
        String[] stArr=sentence.split(" ");
        StringBuilder result=new StringBuilder();
        for(int i=0;i<stArr.length;i++){
            StringBuilder replacement=new StringBuilder();
            if(i!=0) result.append(" ");
            String word=stArr[i];
            TrieNode curr=root;
            for(int k=0;k<word.length();k++){
                char c=word.charAt(k);
                if(curr.children[c-'a']==null || curr.isEnd){
                    break;
                }
                replacement.append(c);
                curr=curr.children[c-'a'];
            }
            if(curr.isEnd){

                result.append(replacement);
            }else{
                result.append(word);
            }
        }

        return result.toString();
    }
}
