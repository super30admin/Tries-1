import java.util.List;
//Approach: 1. Construct a trie dictionary with the words given in the dict. Then we can iterate over the words from the sentence and start building the replacement string for each word.
//2. The replacement string is constructed in such a way that, we keep moving the curr pointer to its children, once if the children is null or if the children has isEnd true, 
//then we will come out of loop.
//3. If we have found a smaller substring with isEnd as true, then we will add it as replacement or will add original string.
class Solution {
    TrieNode root = new TrieNode();
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }
        
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null)
            {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dict, String sentence) {
        for(String word: dict)
        {
            insert(word);
        }
        String[] strArray = sentence.split("\\s+");
        
        
        StringBuilder result = new StringBuilder();
        
        for(int j=0;j<strArray.length;j++)
        {
            
            if(j > 0)result.append(" ");
            String word = strArray[j];
          //  System.out.println(word);
            StringBuilder replaceStr = new StringBuilder();
            TrieNode curr = root;
            for(int i=0;i<word.length();i++)
            {
                char ch = word.charAt(i);
                if(curr.children[ch - 'a'] == null || curr.isEnd )break;
                replaceStr.append(ch);
                curr = curr.children[ch-'a'];
            }
            if(curr.isEnd)
            {
                result.append(replaceStr);
            }else
            {
                result.append(word);
            }
        }
        return result.toString();
    }
}

//Time Complexity : O(nl + ml)  where n is the number of words in dictionary and l is the word length whereas m is the number of words in given sentence.
//Space Complexity : O(nl)  for constructing trie
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :