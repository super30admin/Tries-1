class Solution {
    class TrieNode{
        
        TrieNode[] children;
        String word;
        TrieNode()
        {
            children=new TrieNode[26];
        }
        
    }
    TrieNode root;
    private void insert(String str)
    {
        TrieNode cur=root;
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(cur.children[c-'a']==null)
                cur.children[c-'a']=new TrieNode();
            cur=cur.children[c-'a'];
        }
        
        cur.word=str;
        
        
    }
    public String longestWord(String[] words) {
        
        root=new TrieNode();
        for(int i=0;i<words.length;i++)
        {
            insert(words[i]);
        }
        TrieNode cur=new TrieNode();
        Queue<TrieNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            cur=q.poll();
            for(int i=25;i>=0;i--)
            {
                if(cur.children[i]!=null && cur.children[i].word!=null)
                    q.add(cur.children[i]);
            }
        }
        if(cur.word==null) return "";
        return cur.word;
        
    }
}

// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no