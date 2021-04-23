/*
Runtime complexity - O(mn) + O(kl) where m and n is the size of each char in dictionary, k and l is the size of each in the given sentence
Space complexity - O(N), the size of our trie.
*/

class Solution {
    class Trienode{
        boolean isend;
        Trienode[] children;
        public Trienode()
        {
            isend=false;
            children=new Trienode[26];
        }
    }
    
    Trienode root;
    public void insert(String word)
    {
        Trienode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(curr.children[c-'a']==null)
                curr.children[c-'a']=new Trienode();
            curr=curr.children[c-'a'];
        }
        curr.isend=true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary==null || dictionary.size()==0)
            return sentence;
        root=new Trienode();
        for(String str : dictionary)
        {
            insert(str);
        }
        String[] strarr=sentence.split("\\s+");
        StringBuilder result=new StringBuilder();
        StringBuilder replace;
        for(int k=0;k<strarr.length;k++)
        {
            result.append(' ');
            String word=strarr[k];
            Trienode curr=root;
            replace=new StringBuilder();
            
            for(int i=0;i<word.length();i++)
            {
                char c=word.charAt(i);
                if(curr.children[c-'a']==null || curr.isend)
                    break;
                replace.append(c);
                curr=curr.children[c-'a'];
            }
            //System.out.println(replace.toString());
            if(curr.isend)
                result.append(replace.toString());
            else
                result.append(word);
            
        }
        return result.deleteCharAt(0).toString();
    }
}
