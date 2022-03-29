class Solution {

    private String ans = "";
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String word : words)
        {
            trie.insert(word);
        }

        //dfs
        ans= "";
        dfs(trie.root);
        return ans;
    }

    public void bfs(TrieNode root)
    {
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            TrieNode node = q.remove();
            for (int i = 25 ; i >=0 ;  --i)
            {
                TrieNode child = node.children[i];
                if(child!=null && child.end)
                {
                    ans= child.word;
                    q.add(child);
                }
            }
        }
    }





    public void dfs(TrieNode node)
    {

        //base
        if (node == null || node.end == false)
        {
            return;
        }

        if(node.word.length() > ans.length())
        {
            ans= node.word;
        }

        for (int i = 0 ; i < 26 ; i ++)
        {
            dfs(node.children[i]);
        }
    }
}
class Trie
{
    TrieNode root;

    Trie()
    {
        root = new TrieNode();
        root.end = true;
        root.word ="";
    }

    void insert(String word)
    {
        TrieNode node = root;
        for (int i =0 ; i < word.length() ; ++i)
        {
            char ch = word.charAt(i);
            if(node.children[ch-'a'] == null)
            {
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
        }
        node.end= true;
        node.word = word;
    }
}

class TrieNode
{
    TrieNode[] children;
    boolean end;
    String word;


    TrieNode()
    {
        children = new TrieNode[26];
    }
}