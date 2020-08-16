import java.util.LinkedList;
import java.util.Queue;

class Solution {
	//Approach: 1. Here we construct trie with string given in the input. Then insert the root node in queue and start iterating over the nodes oin queue. Here we travel level wise,
	//so will insert all the children of root node into the queue at same time if they are not null and they have a word associated with it.
	//2. This way we will iterate over the trienode and see which string is the longest one.
	//3. To get the output lexicographically, we will process from right end of the children that way the children with smaller lexicographical values comes out first.
	
    TrieNode root = new TrieNode();
    class TrieNode{
        String wordFormed;
        TrieNode[] children;
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null)
            {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.wordFormed = word;
    }
    public String longestWord(String[] words) {
        for(String word: words)
        {
            insert(word);
        }
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        TrieNode curr = null;
        while(!queue.isEmpty())
        {
            curr = queue.poll();
            for(int i=25;i>=0;i--)
            {
                if(curr.children[i] != null && curr.children[i].wordFormed != null)
                {
                    queue.add(curr.children[i]);
                }
            }
        }
        return curr.wordFormed;
    }
}

//Time Complexity : O(nl)
//Space Complexity : O(nl)  for constructing trie
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :