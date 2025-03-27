import java.util.List;

//Time Complexity : O((m+n)l)
//Space Complexity : O(nl)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//create trie of given dict. then for every word in sentence if its short word is found.
class ReplaceWords {
    private TrieNode root;
    boolean found=false;
    class TrieNode{
        TrieNode[] tn=new TrieNode[26];
        boolean isEnd;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
         root=new TrieNode();
         for(String word: dictionary){
            insert(word);
         }
         String[] strarr=sentence.split(" ");
         StringBuilder sb=new StringBuilder();
         for(String s:strarr){
            //search for smaller prefix
            StringBuilder shortstr = findsubstr(s);
            if(found){
                sb.append(shortstr);
                found=false;
            }else{
                sb.append(s);
            }
            sb.append(" ");

         }
         return sb.toString().trim();
    }

    private StringBuilder findsubstr(String s){
        TrieNode curr=root;
        StringBuilder shortstr=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(curr.tn[ch-'a']==null || curr.isEnd){
                break;
            }
            shortstr.append(ch);
            curr=curr.tn[ch-'a'];
        }
        if(curr.isEnd){
            found=true;
        }
        return shortstr;
    }

    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.tn[ch-'a']==null){
                curr.tn[ch-'a']=new TrieNode();
            }
            curr=curr.tn[ch-'a'];
        }
        curr.isEnd=true;
    }
}
