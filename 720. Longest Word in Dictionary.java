// Time Complexity : O(nl) n is the number of words and l is the average length
// Space Complexity :O(nl)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// we are inserting the each word in a trie. and performing bfs by maintaing a 1:1 mapping b/w the string.
// we iterate from 26 to 0 in the children because the last trienode should get the longest word possible.

class Solution {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for(int i =0; i< word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words)
        {
            insert(root,word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        Queue<String> sq = new LinkedList<>(); 
        q.add(root);
        sq.add("");
        String currstr = "";
        while(!q.isEmpty())
        {
            TrieNode curr = q.poll();
             currstr = sq.poll();
            for(int i=25;i>=0;i--)
            {
                TrieNode child = curr.children[i];
                if(child!=null && child.isEnd)
                {
                    q.add(child);
                    String st = currstr + ((char)('a'+i));
                    sq.add(st);
                }
            }
        }
        return currstr;
    }
}