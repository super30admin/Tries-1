// Time Complexity : O(n)  n length of sentence
// Space Complexity : O(m*n) where m is the length of  dictionary and n is the length of each particular word 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
package Tries-1;

public class ReplaceWords {
    class Solution {
    
        class TrieNode{
            TrieNode [] children;
            boolean isEnd;
            public TrieNode()
            {
                children = new TrieNode[26];
                isEnd = false;
            }
        }
        
        TrieNode root;
        private void insertInTrie(String word)
        {
            TrieNode curr = root;
            for(int i=0;i<word.length();i++)
            {
                char ch = word.charAt(i);
                if(curr.children[ch-'a']==null)
                {
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr = curr.children[ch-'a'];
                System.out.println(ch);
            }
            curr.isEnd = true;
        }
        
        private String findReplacement(String s)
        {
            TrieNode curr = root;
            for(int i=0;i<s.length();i++)
            {
                char ch = s.charAt(i); 
                if(curr.children[ch-'a']== null ) return s;
                if(curr.children[ch-'a']!=null)
                {
                    curr = curr.children[ch-'a'];
                     if(curr.isEnd)
                    {
                        return s.substring(0,i+1);
                    }
                }
               
            }
            return s;
        }
        
        public String replaceWords(List<String> dictionary, String sentence) {
            
            root = new TrieNode();
            if(dictionary == null) return sentence;
            
            for(String word : dictionary)
            {
                insertInTrie(word);
            }
            
            String [] strArray = sentence.split("\\s+");
            StringBuilder sb = new StringBuilder();
            for(String s : strArray)
            {
              String str = findReplacement(s);
              sb.append(str);
              sb.append(" ");
            }
              return sb.toString().trim();
        }
        
      
    }    
}
