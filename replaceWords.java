class Solution {
    class TrieNode{
        TrieNode[] children;
        String isEnd;
        TrieNode()
        {
            children=new TrieNode[26];
        }
    }
    TrieNode root;
    StringBuilder sb;
    private void insert(String word)
    {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(cur.children[c-'a']==null)
                cur.children[c-'a']=new TrieNode();
            cur=cur.children[c-'a'];
        }
        cur.isEnd=word;
    }
    
    private String check(String word)
    {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(cur.children[c-'a']==null)
                return word;
            if(cur.children[c-'a'].isEnd!=null)
                return cur.children[c-'a'].isEnd;
            cur=cur.children[c-'a'];
        }
        
        
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        
        root=new TrieNode();
        for(String string : dictionary)
        {
            insert(string);
        }
        
        String[] strings=sentence.split(" ");
        sb=new StringBuilder();
        
        for(int i=0;i<strings.length;i++)
        {
            sb.append(check(strings[i])+" ");
        }
        
        return sb.toString().trim();
    }
}

// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
