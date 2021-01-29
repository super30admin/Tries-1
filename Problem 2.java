//Time Complexity: O(m*n) where m is the number of words in the String array and n is the average length of the words
//Space Complexity: O(m*n)

//Successfully runs on leetcode: 5 ms

//Approach: Here, we are using Trie data structure to first insert words given in the string array into a Trie data structure
//and at every word, we are maintaining the whole word in the trie. Now, we start with the trie nodes in the reverse way and
//perform bfs on each trie node along with their children. The trienode which will remain in the end inside the queue will
//be the longest word as well as comes first in lexicographical order.


class Solution {
    class TrieNode
    {
        String word;
        TrieNode[] children;
        
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    private void insert(String word)
    {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a']; 
        }
        curr.word = word;
    }
       
    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String word: words)
        {
            insert(word);
        }
        Queue<TrieNode> queue = new LinkedList<>();
        TrieNode curr = root;
        queue.add(root);
        while(!queue.isEmpty())
        {
            curr = queue.poll();
            for(int i = 25; i >= 0; i--)
            {
                if(curr.children[i] != null && curr.children[i].word != null)
                {
                    queue.add(curr.children[i]);
                }
            } 
        }
        return curr.word;
    }
}