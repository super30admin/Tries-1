
// Time Complexity :O(n) n is the length of the senetnce.
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    class TrieNode{
    TrieNode[] children;
    boolean isWord;
    String word;
    TrieNode()
    {
        word = "";
        isWord= false;
        children = new TrieNode[26];
    }
}


TrieNode root;
    public String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        for(String word:dict)
        {
            insert(word);
        }
        String[] tokens = sentence.split(" ");
        for(int i = 0 ; i < tokens.length;i++)
        {
            tokens[i] = searchPrefix(tokens[i]);
        }
        
        return String.join(" ",tokens);
        
        
    }
    
      private void insert(String word) {
        TrieNode Node = root;
        for(char c:word.toCharArray())
        {
            if(Node.children[c-'a']==null)
            {
               Node.children[c-'a'] = new TrieNode();
            }
            Node = Node.children[c-'a'];
        }
        Node.isWord= true;
      Node.word = word;
    }
    private String searchPrefix(String word)
    {
        TrieNode Node = root;
        for(char c:word.toCharArray())
        {
            
            if(Node.children[c-'a']==null)
            {
                return word;
            }
            Node = Node.children[c-'a'];
            if(Node.isWord)
            {
                return Node.word;
            }
           
        }
      return word;
    }
}