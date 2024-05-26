import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class TrieNode
    {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode()
        {
            this.children = new TrieNode[26];
        }
    }
    
    private void insert(String word)
    {
        TrieNode curr = root;
        for(int i=0; i< word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
            {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    TrieNode root;
    
    public String longestWord(String[] words) {
        this.root = new TrieNode();

        for(String word : words)
        {
            insert(word);
        }        

        //search for the longest word
       Queue<TrieNode> q = new LinkedList<>();
       Queue<String> sq = new LinkedList<>();

       q.add(root);
       sq.add("");

       TrieNode curr = null;
       String str = "";

       while(!q.isEmpty())
       {
        curr = q.poll();
        str = sq.poll();

        for(int i=25; i>=0; i--)
        {
            if(curr.children[i] != null && curr.children[i].isEnd)
            {
                q.add(curr.children[i]);
                String newStr = str + (char)(i + 'a');
                sq.add(newStr);
            }
        }
       }
        return str;

    }

    
}