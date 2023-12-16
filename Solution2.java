//Replace Words
//TC max (m and n) * l
// where m->dictinaory length, n-> length of sentence , l-> word length
//SC max (m and n) * l
class TrieNode
{
    boolean isEnd;
    TrieNode[] children;

    public TrieNode()
    {
        children=new TrieNode[26];
    }
}
class Solution {

     TrieNode root;
    public void insert(String word,TrieNode root)
    {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(curr.children[c-'a']==null)//character /letter not present in trie
            {
                curr.children[c-'a']=new TrieNode();
            }
             curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }

    public String replaceWords(List<String> dictionary, String sentence)    {

        TrieNode root=new TrieNode();
        //store the dictornary root words in trie first
        for(String word:dictionary)
        {
            insert(word,root);
        }

        //split the sentence into array
        String[] splitArray=sentence.split(" ");
        StringBuilder result=new StringBuilder();
        for(int i=0;i<splitArray.length;i++)
        {
            if(i>0)
            {
                result.append(" ");//add spaces in output string
            }
            String word1=splitArray[i];
            TrieNode curr=root;
            StringBuilder replacement=new StringBuilder();
            for(int k=0;k<word1.length();k++)
            {
                char c=word1.charAt(k);
                if(curr.children[c-'a']==null || curr.isEnd)
                //word not there in trie or end of word is reached
                {
                    break;
                }
                replacement.append(c);
                curr=curr.children[c-'a'];
            }
           
            if(curr.isEnd)
            {
                   result.append(replacement);
            }
             else
            {
                // no need to replace word since its root word not present in trie
                result.append(word1);
            }
        }

       return result.toString(); 
    }
}