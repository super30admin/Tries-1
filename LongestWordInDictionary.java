// TC: O(M*N) -> M: avg length of word, N -> no. of words
// SC: O(M*N) -> M: avg length of word, N -> no. of words
// Did it run successfully on Leetcode? : Yes
class Solution { 
  class TrieNode {
    String word;
    TrieNode[] children;
    TrieNode()
    {
       children = new TrieNode[26];
    }
  }
    TrieNode root;
    private void insert(String word)
    {
        TrieNode cur = root;
        for ( int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = word;  
    }

    public String longestWord(String[] words) {
        if ( words == null || words.length == 0)
            return "";
        root = new TrieNode();
        for (String word: words)
        {
            insert(word);
        }
        // BFS
        Queue<TrieNode> q = new LinkedList();
        q.offer(root);
        TrieNode cur = root;
        while (!q.isEmpty())
        {
           cur = q.poll();
            for ( int i = 25; i >=0; i--)
            {
               if (cur.children[i] != null && cur.children[i].word != null)
                   q.offer(cur.children[i]);
            }
        }
        return cur.word;
    }
}
