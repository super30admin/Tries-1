class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children=new TrieNode[26];
    }
    private TrieNode root;
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
          char c=word.charAt(i);
            if(curr.children[c-'a']==null)
            {
               curr.children[c-'a']=new TrieNode(); 
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
        
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root=new TrieNode();
        for(String word: dictionary)
        {
            insert(word);
        }
       String[] strings=sentence.split(" ");
       StringBuilder result=new StringBuilder();
       for(int i=0;i<strings.length;i++)
       {
          if(i!=0)
          result.append(" ");
           String curr_word=strings[i];
           StringBuilder sb=new StringBuilder();
           TrieNode curr=root;
           for(int j=0;j<curr_word.length();j++)
           {
                 char c=curr_word.charAt(j);
                 if(curr.children[c-'a']==null||curr.isEnd)
                 break;
                 sb.append(c);
                 curr=curr.children[c-'a'];
           }
           if(curr.isEnd)
           {
               result.append(sb);
           }
           else
           {
               result.append(curr_word);
           }
       }
       return result.toString();
    }
}