// Time Complexity :O(nl)
// Space Complexity :O(nl) n-number of strings, l-average length of each string 
// Did this code successfully run on Leetcode :yes
class Solution {
    class TrieNode {
            String word;
            TrieNode[] children;
            public TrieNode()
            {
                children=new TrieNode[26];
            }
        }
            TrieNode root;
        /** Initialize your data structure here. */
        public Solution() {
           root=new TrieNode(); 
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode temp=root;
            for(int i=0;i<word.length();i++)
            {
                char c=word.charAt(i);
                if(temp.children[c-'a']==null)
                    temp.children[c-'a']=new TrieNode();
                temp=temp.children[c-'a'];
            }
            temp.word=word;

        }
    public String longestWord(String[] words) {
        for(String s:words)
        {
            insert(s);
        }
        
        Queue<TrieNode> q=new LinkedList<>();
        q.add(root);
        TrieNode temp=null;
        while(!q.isEmpty())
        {
            temp=q.poll();
            for(int i=25;i>=0;i--)
            {
                if(temp.children[i]!=null && temp.children[i].word!=null)
                    q.add(temp.children[i]);
                   
            }
            
        }
        return temp.word;
    }
}