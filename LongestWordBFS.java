class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        //char ch;
        String word;
        public TrieNode()
        {
            children = new TrieNode[26];
        }
        
    }
    TrieNode root;
    
    public void insert(String word)
    {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            
            if(curr.children[c-'a'] == null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
            //curr.ch = c;//maintain current word
        }
        curr.isEnd = true;
        //curr.ch = c;
        curr.word = word;
    }
    
   // String result;
    public String longestWord(String[] words) {
        //insert into trie
        root = new TrieNode();
       // result = "";
        for(String word : words)//nl
        {
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        //bfs
        TrieNode curr = null;
        while(!q.isEmpty())
        {
            curr = q.poll();
            for(int i=25;i>=0;i--)
            {
            if(curr.children[i] != null && curr.children[i].isEnd)
            {
                q.add(curr.children[i]);
            }
            }
        }
        return curr.word;
    }

}