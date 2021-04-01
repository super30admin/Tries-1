// Time Complexity :O(summation of length of each word in the input array)
// Space Complexity :O(summation of length of each word in the input array)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
  
  class TrieNode{
    TrieNode[] children;
    boolean isWord;
    char c;
    
    public TrieNode(){
      children = new TrieNode[26];
      isWord = false;
      this.c = c;
    }
  }
        TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {
      
      for(String word: dictionary)
      {
        insert(word);
      }
      
      
      //get words from sentence
      String[] words = sentence.split(" ");
      StringBuilder sb = new StringBuilder();
      for(String word: words)
      {
        sb.append(getRoot(word));
        sb.append(" ");
      }
        //trim the leading space that we get in the previous for loop
        return sb.toString().trim();
    }
  
    //to have trienode for each word in the dictionary
    private void insert(String word)
    {
      TrieNode current = root;
      for(char ch:word.toCharArray())
      {
        if(current.children[ch-'a']==null)
        {
          current.children[ch-'a']=new TrieNode();
        }
        current = current.children[ch-'a'];
      }
      current.isWord= true;
    }
  
  
  private String getRoot(String word)
  {
    TrieNode current = root;
    StringBuilder sb = new StringBuilder();
    
    for(char ch:word.toCharArray())
    {
      if(current.children[ch-'a']!=null)
      {
        current = current.children[ch-'a'];
        sb.append(ch);
        if(current.isWord)
        {
          return new String(sb);
        }
      }
      else
      {
        break;
      }
      
    }
      return word;
  }
}