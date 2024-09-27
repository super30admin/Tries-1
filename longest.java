class Solution {
    class TrieNode{
        String word;
        TrieNode[] children;
        public TrieNode()
        {
            children=new TrieNode[26];
        }
    }
    TrieNode root=new TrieNode();
    public void insert(String word)
    {
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
        curr.word=word;
    }
    public String longestWord(String[] words) {
        for(String s: words)
        {
            insert(s);
        }
        Queue<TrieNode> queue=new LinkedList<>();
        queue.add(root);
        TrieNode node=null;
        while(!queue.isEmpty())
        {
            node=queue.poll();
            for(int i=25;i>=0;i--)
            {
                if(node.children[i]!=null && node.children[i].word!=null)
                {
                    queue.add(node.children[i]);
                }
            }
        }
        return node.word;
    }
}