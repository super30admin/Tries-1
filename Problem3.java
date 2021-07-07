class Solution {
    
    class TrieNode { 
        String value;
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root = new TrieNode();

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode curr = root;

        //go through each prefix characters
        for(int i = 0; i < word.length(); ++i)
        {
            if(curr.children[word.charAt(i) - 'a'] == null)
                curr.children[word.charAt(i)- 'a'] = new TrieNode();

            curr = curr.children[word.charAt(i) - 'a'];
        }

        curr.isEnd = true;
        curr.value = word;
        return;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        //Initiate Root
        TrieNode node = root;

        for(int i = 0; i < word.length(); ++i)
        { 
            if(node.children[word.charAt(i) - 'a'] == null) return false;

            node = node.children[word.charAt(i) - 'a'];
        }

        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        //Initiate Trie
        TrieNode curr = root;

        for(int i= 0 ; i < prefix.length(); ++i)
        {
            if(curr.children[prefix.charAt(i)- 'a'] == null) return false;

            curr = curr.children[prefix.charAt(i) - 'a'];
        }

        return true;
    }
    
    public String longestWord(String[] words) {
        
        for(String w : words)
            insert(w);
        
        return findLW();
    }
    
    private String findLW()
    {
        TrieNode curr = root;
        
        StringBuilder sb = new StringBuilder();
        
        Queue<TrieNode> qu = new LinkedList<>();
        
        qu.add(curr);
        
        while(!qu.isEmpty())
        {
            TrieNode cN = qu.poll();
            
            sb = new StringBuilder();
            sb.append(cN.value);
            
            for(int i = 25; i >= 0; i--)
            {
                if(cN.children[i] != null && cN.children[i].isEnd)
                    qu.add(cN.children[i]);
            }
        }
        
        return sb.toString();
        
    }
}
