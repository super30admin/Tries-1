// TC: O(D * L), where D is the number of words in the dictionary and L is the average length of the words.
// SC: O(D * L)


// The code defines a nested class TrieNode to represent nodes in the Trie. Each node has a boolean flag 
// isEnd to indicate if it marks the end of a word, and an array children to store references to child nodes.

// A Trie object root is created as the root of the Trie.

// The provided dictionary is inserted into the Trie by iterating over each word in the
// dictionary and traversing the Trie to create the corresponding nodes.

// The sentence is split into an array of words using the space delimiter. For each word, 
// it is checked against the Trie to find the root. If a root is found, it is appended to the ans StringBuilder. 
// If not, the original word is appended. Finally, the ans StringBuilder is converted to a string and returned as the result.


class Solution {
    class TrieNode
    {
        boolean isEnd;
        TrieNode[] children;

        TrieNode()
        {
            isEnd=false;
            children= new TrieNode[26];
        }
    }

    TrieNode root=new TrieNode();
    
    public String replaceWords(List<String> dictionary, String sentence) 
    {
         
        for(int i=0;i<dictionary.size();i++)
        {
              String str=dictionary.get(i);
              TrieNode curr=root;
              for(int j=0;j<str.length();j++)
              {
                  char temp=str.charAt(j);
                  if(curr.children[temp-'a']==null)
                  curr.children[temp-'a']=new TrieNode();
                  curr=curr.children[temp-'a'];
              }
              curr.isEnd=true;
        }
       
        // Splitting a sentence
        String[] a=sentence.split(" ");
        StringBuilder ans=new StringBuilder();

    
       
        for(int i=0;i<a.length;i++)
        {

              String str=a[i];
              StringBuilder replacement =new StringBuilder();
            //   Traversing through trie for each word in sentence if we found root i.e., isEnd =true rpelce word with root else
            // replace with original word
               TrieNode curr=root;
              for(int j=0;j<str.length();j++)
              {
                  char temp=str.charAt(j);
                  //System.out.println(str);
                  if(curr.children[temp-'a']==null || curr.isEnd==true)
                  {
                    break;
                  }
                  replacement.append(temp);
                  curr=curr.children[temp-'a'];
              }
    
              if(curr.isEnd==true)
              {
                  ans.append(replacement);
              }
              else
              {
                  ans.append(str);
              }
              if(i<a.length-1)
              ans.append(" ");
        }

     return ans.toString();
    }
}