import java.util.List;
class Solution {
    class Node
    {
        Node[] children;
        boolean eow;

        Node(){
        children= new Node[26];
        eow=false;
         }
    }
    Node root;

    public void insert(String word)
    {
        Node curr= root;
        for(int i=0;i<word.length(); i++)
        {
            char c= word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a']= new Node();
            }
            curr= curr.children[c-'a'];
        }
        curr.eow=true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        if(sentence==null || sentence.length()==0)
        {
            return sentence;
        }
        root= new Node();
        for(String s: dictionary)
        {
            insert(s);
        }
        String[] strarray= sentence.split(" ");
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<strarray.length;i++)
        {
            if(i!=0)
            {
                answer.append(" ");
            }
            String word=strarray[i];
            Node curr=root;
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<word.length();j++)
            {
                char c= word.charAt(j);
                if(curr.children[c-'a']==null ||curr.eow==true)
                {
                    break;
                }
                sb.append(c);
                curr=curr.children[c-'a'];
            }
            if(curr.eow)
            {
                answer.append(sb);
            }
            else{
                answer.append(word);
            }
        }
        return answer.toString();
    }
}
