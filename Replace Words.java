// Time Complexity : O(nxl)
// Space Complexity : O(nxl)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We insert all the dictionary words in the trie. Split the sentence and store it in an array. 
//Iterate through all the words in the sentence and then iterate through all its charachters and check if these characters are the children of the root node. 
//If the last letter has isEnd as true then we append this word to the final sentence.

class Solution {
    class TrieNode
    {
        boolean isEnd;
        TrieNode [] children;
        public TrieNode()
        {
            this.children=new TrieNode[26];
        }
    }

    private void insert(String word, TrieNode root)
    {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c= word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
            curr.isEnd=true;
    }

    public String replaceWords(List<String> dictionary, String sentence) 
    {
        TrieNode root=new TrieNode();
        //insert all the words from the dictionary in the trie
        for(String word:dictionary)
        {
            insert(word,root);
        }
        StringBuilder result=new StringBuilder(); 
        //We will split the Sentence and store it in an array
        String[] SplitArr=sentence.split(" ");
        //We will iterate through each word in the sentence
        
        for(int i=0; i<SplitArr.length;i++)
        {
            // We will check if words in the dictionary are prefix of the words in the sentences
            String word=SplitArr[i];
            System.out.println(word);

            if(i>0) result.append(" ");

            StringBuilder replacement=new StringBuilder();
            TrieNode curr=root;


            // We will make a replacement word of each word from the sentence
            for(int k=0;k<word.length();k++)
            {
                char c=word.charAt(k);
                //System.out.println(c);
                if(curr.children[c-'a']==null || curr.isEnd)
                { 
                    break; 
                }

                curr=curr.children[c-'a'];
                replacement.append(c);
                //System.out.println(replacement);
            }

            if(curr.isEnd)
            {
                result.append(replacement); // if the dictionary word was present
            }
            else
            {
                result.append(word);   //if not then we append the original word
            }
        }
        return result.toString();
    }
}
