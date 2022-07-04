//Time Complexity=O(n*l)
//Space Complexity=O(1)
public class LongestWord {

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

    public String longestWord(String[] words) {
        for(String st:words){
            insert(st);
        }
        int maxCount=0;
        StringBuilder result=new StringBuilder();
        for(int i=0;i<words.length;i++){

            TrieNode curr=root;
            StringBuilder sb=new StringBuilder();
            String str=words[i];
            int count=0;
            for(int k=0;k<str.length();k++){
                char c=str.charAt(k);
                curr=curr.children[c-'a'];
                if(curr!=null){
                    if(curr.isEnd==true){
                        count++;
                    }else{
                        count=0;
                        break;
                    }
                }
            }

            if(count!=0 &&count==maxCount){
                String str1=result.toString();
                if(str1.compareTo(str)>0){
                    sb.append(str);
                    result=sb;
                }
            }
            if(count>maxCount){
                maxCount=count;
                sb.append(str);
                result=sb;
            }

        }
        return result.toString();
    }
}
