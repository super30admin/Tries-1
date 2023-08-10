// Time Complexity : O(N*k) k=length of the longest word
// Space Complexity : O(N*k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will store all the words in trie. Then we will traverse through all the children of the TrieNode and check if all the child nodes have isEnd true by using a recursive dfs function. 
// Whenever we find a valid word, we append it to the path and if we don't then we backtrack. We will save the path and compare it with the longest String found so far. 

class Solution {

    class TrieNode
    {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode()
        {
            this.children=new TrieNode[26];
        }
    }

//function to insert the words in trie
    private void insert(String word,TrieNode root)
    {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    

    public String longestWord(String[] words) 
    {
        TrieNode root=new TrieNode();
        //add all the words in the words array to trie
        for(String word: words)
        {
            insert(word,root);
        }
        StringBuilder longest=new StringBuilder();
        dfs(root,new StringBuilder(),longest);
        return longest.toString();  
    }

    private void dfs(TrieNode curr,StringBuilder path,StringBuilder longest)
    {
        //base
        if(path.length()>longest.length())
        {
            longest.setLength(0);   //clearing longest
            longest.append(path);   //storing the value of path in longest
        }

        //logic
        for(int i=0;i<26;i++)   //iterating through all the children of a node
        {
            if(curr.children[i]!=null && curr.children[i].isEnd)
            {
                //casting the ascii value of the character in the child node to char
                char nextChar=(char)(i+'a'); 
                //action
                path.append(nextChar);      //appending the character to the path  
                //recurse
                dfs(curr.children[i],path,longest); 
                //backtrack
                path.setLength(path.length()-1);
            }
        }
    }
   
}
