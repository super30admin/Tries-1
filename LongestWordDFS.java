class Solution {
    ///tc-nk
    //sc-nk
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        char ch;
        public TrieNode()
        {
            children = new TrieNode[26];
        }
        
    }
    TrieNode root;
    
    public void insert(String word)
    {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            
            if(curr.children[c-'a'] == null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
            curr.ch = c;//maintain current word
        }
        curr.isEnd = true;
    }
    
    String result;
    public String longestWord(String[] words) {
        //insert into trie
        root = new TrieNode();
        result = "";
        for(String word : words)
        {
            insert(word);
        }
        String path = "";
        backtrack(root,new StringBuilder());
        return result;
        
        
    }
    private void backtrack(TrieNode root, StringBuilder path)
    {
        //base case
        if(path.length() > result.length())
        {
            result = path.toString();
        }
        
        //logic
        for(int i=0;i<26;i++)
        {
            if(root.children[i]!=null && root.children[i].isEnd)
            {
            //action
            path.append(root.children[i].ch);
            //recurse
            backtrack(root.children[i],path);
            //backtrack
            path.setLength(path.length()-1);    
            }
        }
        
        
    }
}