//Time Complexity: o(mn)
//space: o(mn) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    class Trie {
        boolean flag;
        Trie[] child;
        String str;
        public Trie()
        {
            child = new Trie[26];
        }
    }
    Trie root;
    Trie curr;
    Queue<Trie> q = new LinkedList<>();
    public String longestWord(String[] words) {
        root = new Trie();
        
        for(String word: words)
        {
            Insert(word);
        }

        q.add(root);

        while(!q.isEmpty())
        {
            curr = q.poll();
            for (int i = 25; i>=0; i--){
                if(curr.child[i] != null && curr.child[i].flag == true)
                {
                    q.add(curr.child[i]);
                }
            }
        }
        return (curr.str);
    }
    private void Insert(String word)
    {
        Trie curr = root;
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.child[c - 'a'] == null)
            {
                curr.child[c - 'a'] = new Trie();

            }
            curr = curr.child[c - 'a'];
        }
        curr.flag = true;
        curr.str = word;
    }
}