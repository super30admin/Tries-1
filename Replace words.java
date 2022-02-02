//Time complexity: O(n*l)+0(m*k)
//n= number of words in dictionary, l=length of each word in dictionary
//m= number of strings in the splitted array, k= length of each string in that array


class Solution {
    class TrieNode
{
    TrieNode[]children;
    boolean isEnd;
    
    public TrieNode()
    {
        children= new TrieNode[26];
    }
    }
    
    TrieNode root;
    public void insert(String word)
    {
        TrieNode curr=root;
            for(int i=0;i<word.length();i++)
            {
                char ch=word.charAt(i);
                if(curr.children[ch-'a']==null)
                {
                    curr.children[ch-'a']=new TrieNode();
                }
                curr=curr.children[ch-'a'];
    }
        curr.isEnd=true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new TrieNode();
        for(String word: dictionary)
        {
            insert(word);
        }
        StringBuilder result=new StringBuilder();
        String spltArr[] = sentence.split(" ");
        for(int i=0;i<spltArr.length;i++)
        {
            TrieNode curr=root;
            StringBuilder replacement=new StringBuilder();
            if(i!=0) result.append(" ");
            for(int j=0;j<spltArr[i].length();j++)
            {
                char ch= spltArr[i].charAt(j);
                if(curr.children[ch-'a']==null || curr.isEnd==true)
                    break;
                replacement.append(ch);
                curr=curr.children[ch-'a'];
                
            }
            if(curr.isEnd==true)
                result.append(replacement);
            else
            result.append(spltArr[i]);
                
        }
        return result.toString();
        }
    
}