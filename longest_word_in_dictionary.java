//Time Complexity: O(n) ==> no of words in input
//Space Complexity: O(n) ==> size of trie

class Solution {
    
     class TrieNode{
        String word;
        //each child node is an array of 26 characters
        TrieNode[] children;
        
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }
    
    
     TrieNode root = new TrieNode();
    public void insert(String word) {
        
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            //if we reach till the end insert a new node
            if(curr.children[c-'a']== null)
                curr.children[c-'a'] = new TrieNode();
            //otherwise iterate through Trie until we reach last node
            curr = curr.children[c-'a'];
        }
           curr.word = word;  
    }
    
    
    public String longestWord(String[] words) {
        
        for(String word : words)
            insert(word);
       
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = null;
        while(!q.isEmpty())
        {
           curr = q.poll(); 
           for(int i=25; i>=0; i--)
            {
                if(curr.children[i]!=null && curr.children[i].word !=null)
                    q.add(curr.children[i]);
               }
        
        }
        
        return curr.word;
    }
}
