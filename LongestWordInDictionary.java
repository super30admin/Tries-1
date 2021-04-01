// Time Complexity :O(summation of length of each word in the input array)
// Space Complexity :O(summation of length of each word in the input array)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
  
  class TrieNode
  {
    TrieNode children[];
    String Word;
    
    public TrieNode()
    {
      children = new TrieNode[26];
      Word = "";
    }
  }
  
  TrieNode root;
  String result ="";
    public String longestWord(String[] words) {
      
      if(words == null || words.length==0)
      {
        return result;
      }
      
      root = new TrieNode();
      
      
      insert(words);
      
      dfs(root);
        return result;
    }
  
  //creating a trie with each input word and keeping track of word at every level
    private void insert(String[] words)
    {
      for(String word : words)
      {
        TrieNode current = root;
        for(char ch : word.toCharArray())
        {
          if(current.children[ch-'a']==null)
          {
            current.children[ch-'a']= new TrieNode();
          }
          current = current.children[ch-'a'];
        }
        current.Word=word;
      }
    }
  
  
  private void dfs(TrieNode root)
  {
    //update the result when we have a the word lenght bigger than the result , this way we will have the longest word in the end
    if(root.Word.length()>result.length())
    {
      result=root.Word;
    }
    
    //traversing the nodes of the trie to check the stopping condition
    for(int i=0;i<26;i++)
    {
      if(root.children[i]!=null && root.children[i].Word!="")
      {
        dfs(root.children[i]);
      }
    }
  }
}