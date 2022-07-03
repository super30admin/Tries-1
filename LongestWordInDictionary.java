class Solution {
    class TrieNode {
        
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    StringBuilder res;
    public String longestWord(String[] words) {
        root = new TrieNode();
        res = new StringBuilder();
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String s, String t)
            {
                return s.length()-t.length();
            }
        });
       
        for( String s :words)
            insert(s);
        
        return res.toString();
        
    }
    
    private void insert(String s)
    {
        TrieNode curr= root;
        for(int i =0;i<s.length()-1;i++)
        {
            if(curr.children[s.charAt(i)-'a']==null)
                return;
            curr= curr.children[s.charAt(i)-'a'];
            
        }
        curr.children[s.charAt(s.length()-1)-'a']= new TrieNode();
        
        if(res.toString().length()==s.length() && s.compareTo(res.toString())<0)
        {
            res = new StringBuilder(s);
        }
      else  if(s.length()>res.toString().length())
        {
            res = new StringBuilder(s);
        }
        
    }
}