//Time Complexity for insert,search = O(length of string)
//Time Complexity for startsWith = O(length of string to be found)

import java.util.*;
class ImplementTrie
{
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;


        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public ImplementTrie(){
        root = new TrieNode();
    }

    public void insert(String word)
    {
        TrieNode curr = root;

        for(int i =0;i<word.length();i++)
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

    public boolean search(String word)
    {
        TrieNode curr = root;

        for(int i =0;i<word.length();i++)
        {
            char c = word.charAt(i);

            if(curr.children[c-'a'] == null)
            {
                return false;
            }

            curr = curr.children[c-'a'];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String word)
    {
        TrieNode curr = root;

        for(int i =0;i<word.length();i++)
        {
            char c = word.charAt(i);

            if(curr.children[c-'a'] == null)
            {
                return false;
            }

            curr = curr.children[c-'a'];
        }

        return true;
    }
}