// Time Complexity : O(n*m) where n is the number of word and m is the no of operation for each string
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Figuring out the dfs function


// Your code here along with comments explaining your approach
class Solution {
    class TrieNode{
    TrieNode[] children;
    String word;
    TrieNode()
    {
        word = "";
        children = new TrieNode[26];
    }
}
    
    private  void insert(String word) {
        TrieNode Node = root;
        for(char c:word.toCharArray())
        {
            if(Node.children[c-'a']==null)
            {
               Node.children[c-'a'] = new TrieNode();
            }
            Node = Node.children[c-'a'];
        }
        Node.word=word;
    }
    TrieNode root;
    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String word: words)
        {
            insert(word);
        }
        return dfs(root);
    }
    private String dfs(TrieNode root)
    {
        String output = root.word;
   
        for(int i = 0; i <26;i++)
        {
            if(root.children[i]!=null && root.children[i].word!="")
            {
             
               String temp = dfs(root.children[i]);
                if(temp.length()>output.length())
                {
                    output = temp;
                }
            }
          
            
        }
        return output;
    }
}