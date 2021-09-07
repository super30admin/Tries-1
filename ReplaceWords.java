
// Time Complexity : O(L) L: length of words
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, did not understand the approach


// Your code here along with comments explaining your approach
/*
Approach:
1) So in this problem we need to use the root words and put them in place of successors.
2) Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
   Output: "the cat was rat by the bat"
3) Thus we make use of Trie Data Structure
4) we first create a trieNode with every character of the every word of dictionary -> we use the insert function of trie for the same.
5) Then we split the sentences on white spaces. suppose we have the first word as "the" -> we have the first char as 't', then we check if the TrieNode has its children already.
if not, we just go to the next character else we assign the current pointer to the current character of the node. 
6) if the curr pointer has reached the end of the character, then we add the it in replecement string builder else we add the complete word in string builder.
*/



class Solution {
    
    class TrieNode{
        
        TrieNode children[];
        boolean isEnd;
        
        public TrieNode()
        {
            children = new TrieNode[26];
           
            
        }
    }
    
    TrieNode root;
    
    public void insert(String word)
    {
        
        TrieNode curr =root;
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a']= new TrieNode();
               
            }
             curr = curr.children[c-'a'];
                
            
        }
        
        curr.isEnd=true;
        
    }
        
    
    
    public String replaceWords(List<String> dictionary, String sentence) {
       if(sentence ==null || sentence.length()==0)
       {
           return sentence;
       }
       root = new TrieNode();
       for(String word: dictionary)
       {
           insert(word);
       }
    
        String strArray[] = sentence.split("\\s+"); // split on one or more white spaces
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strArray.length;i++)
        {
            if(i>0)
            {
                sb.append(" ");
            }
            String word = strArray[i];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr =root;
            for(int j=0;j<word.length();j++)
            {
                char c = word.charAt(j);
                if(curr.children[c-'a']==null || curr.isEnd)
                {
                    break;
                }
                
                curr=curr.children[c-'a'];
                replacement.append(c);
                
            }
            
            if(curr.isEnd)
            {
                sb.append(replacement);
            }
            else
            {
                sb.append(word);
            }
        }
        
        
        
        return sb.toString();
    }
}