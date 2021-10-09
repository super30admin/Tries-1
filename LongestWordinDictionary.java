// Time Complexity : building Trie will take n*k
// Space Complexity : 
// Did this code successfully run on GeeksforGeeks : yes
// Any problem you faced while coding this : not sure about time and space complexity


// Your code here along with comments explaining your approach


class Solution {
    
    class TrieNode
    {
        TrieNode[] children;
        String word;
        
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    
    private void insert(String word)
    {
        TrieNode node = root;
        for(int i =0; i < word.length();i++)
        {
            char c = word.charAt(i);
            if(node.children[c-'a'] == null)
            node.children[c-'a'] = new TrieNode(); 
            node = node.children[c-'a'];
        }
        node.word = word;
        
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        for(int i = 0 ; i < words.length; i++)
        {
            insert(words[i]);
        }
        
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = new TrieNode();
        while(!q.isEmpty())
        {
            curr = q.poll();
            
            for(int i = 25; i >=0; i--)
            {
              if(curr.children[i] != null && curr.children[i].word != null)
               {
                   q.add(curr.children[i]);
               }
            }
            
            
        }
        if(curr.word != null ) return curr.word;
             return "";
    }
}