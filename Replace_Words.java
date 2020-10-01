//Time Complexity-O(n)
//Space Complexity-O(n) where n is number of characters in dictionary
class Solution {
    public class TriesNode{
        TriesNode[] children;
        String word;
        TriesNode()
        {
            children=new TriesNode[26];
            word="";
        }
    }
    private TriesNode root;

    public String replaceWords(List<String> dictionary, String sentence) {
        createTries(dictionary);        
        String[] arr=replaceSuccessor(sentence);
        String replaceSentence="";
        for(String newString:arr)
        {
            if(replaceSentence.length()>0)
            {
                replaceSentence=replaceSentence+" "+newString;
            }
            else
            {
                replaceSentence=newString;
            }
        }
        return replaceSentence;
        
        
    }
    void createTries(List<String>dictionary)
    {
        root=new TriesNode();
        for(String word:dictionary)
        {
            TriesNode cur=root;
            for(int i=0;i<word.length();i++)
            {
                char ch=word.charAt(i);
                if(cur.children[ch-'a']==null)
                {
                    cur.children[ch-'a']=new TriesNode();
                }
                cur=cur.children[ch-'a'];
            }
            cur.word=word;
        }
    }
    
    String[] replaceSuccessor(String sentence)
    {
        String[] sentences=sentence.split(" ");
        
        for(int i=0;i<sentences.length;i++)
        {
            startsWith(sentences[i],i,sentences);
        }
        return  sentences;  
    }
    
    void startsWith(String word,int j,String[] sentences)
    {
        TriesNode cur=root;
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(cur.children[ch-'a']==null||
               cur.word!="")
            {
                break;
            }
            cur=cur.children[ch-'a'];
        }
        if(cur.word!="")
        {
            sentences[j]=cur.word;
        }
    }

}