package org.example;

// Time Complexity : O(m*l)  ->m is the number of words  & l is the length of each word
// Space Complexity : O(m*l)
// Did this code successfully run on Leetcode : Yes

public class LongestWordInDictionaryUsingTriesAndDFS {
    StringBuilder result;
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode()
        {
            this.children = new TrieNode[26];
        }
    }

    public void insert(TrieNode root, String word)
    {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public String longestWord(String[] words) {

        TrieNode root = new TrieNode();
        this.result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        // insert all the words in the trienode
        for(int i=0; i<words.length; i++)  // m * l
        {
            insert(root, words[i]);
        }
        //dfs to find the maximun length String
        dfs(root, temp);   //m * l
        return result.toString();

    }

    public void dfs(TrieNode root, StringBuilder temp)
    {
        //base
        if(result.length() < temp.length())
        {
            result = new StringBuilder(temp);
        }

        //logic
        if(root!=null)
        {
            for(int i=0; i<26; i++)
            {
                if(root.children[i]!=null && root.children[i].isEnd)
                {
                    int len = temp.length();
                    temp.append((char)(i+'a'));  //append
                    dfs(root.children[i], temp);  // recurse
                    temp.setLength(len);  // backtrack
                }
            }
        }
    }
}