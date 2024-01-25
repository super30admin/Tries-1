// Time Complexity : O(n * l) => l = average length of string
// Space Complexity : O(n * l)
// Method used : BFS

class Solution {

    class TrieNode
    {
        TrieNode[] node;
        String name;

        public TrieNode()
        {
            node = new TrieNode[26];
            name = null;
        }
    }

    TrieNode root = new TrieNode();

    public String longestWord(String[] words) {
        
        for(String word : words) implementTrie(word);

        String result = bfs();

        return result == null ? "" : result;
    }

    private void implementTrie(String word)
    {
        TrieNode temp = root;
        char c;

        for(int i = 0; i < word.length(); i++)
        {
            c = word.charAt(i);

            if(temp.node[c - 'a'] == null) temp.node[c - 'a'] = new TrieNode();

            temp = temp.node[c - 'a'];
        }

        temp.name = word;
    }

    private String bfs()
    {
        TrieNode temp = null;

        Queue<TrieNode> queue = new LinkedList();

        queue.add(root);

        while(!queue.isEmpty())
        {
            temp = queue.poll();

            for(int i = 25; i >= 0; i--)
            {
                if(temp.node[i] != null && temp.node[i].name != null)
                {
                    queue.add(temp.node[i]);
                } 
            }
        }

        return temp.name;
    }
}