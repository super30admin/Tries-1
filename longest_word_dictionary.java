class Solution {
    int max;
    String result;
      class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode()
        {
            this.children=new TrieNode[26];
        }
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
    public String longestWord(String[] words) {
        this.max=Integer.MIN_VALUE;
        this.root=new TrieNode();
        for(int i=0;i<words.length;i++)
        {
            insert(words[i]);
        }
        Arrays.sort(words);
        int count;
        for(String curr_word:words)
        {
            TrieNode curr=root;
            count=0;
            for(int i=0;i<curr_word.length();i++)
            {
               char c=curr_word.charAt(i);
               if(curr.isEnd)
               count++;
               curr=curr.children[c-'a'];
            }
           if(count==curr_word.length()-1)
           {
            if(count>max)
            {
                max=count;
                result=curr_word;
            }
           }
        }
if(result==null)
return "";
        
return result; 
        
    }
}