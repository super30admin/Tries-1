package org.example;

// Time Complexity : O(m*l)  ->m is the number of words  & l is the length of each word
// Space Complexity : O(m*l)
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

public class LongestWordInDictUsingTriesAndBFS {

    String result;
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
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
        this.result = "";
        String temp = "";

        for(String word:words)
        {
            insert(root, word);
        }

        return bfs(root, temp);
    }

    public String bfs(TrieNode root, String temp){

        String cuuStr = "";
        Queue<TrieNode> trieq = new LinkedList<>();
        Queue<String> strq = new LinkedList<>();
        trieq.add(root);
        strq.add(temp);
        while(!trieq.isEmpty())
        {
            TrieNode currTrie = trieq.poll();
            cuuStr = strq.poll();
            for(int i=25; i>=0; i--)
            {
                if(currTrie.children[i]!=null && currTrie.children[i].isEnd)
                {
                    trieq.add(currTrie.children[i]);
                    String t = cuuStr + ((char)(i+'a'));
                    strq.add(t);
                }
            }

        }
        return cuuStr;

    }
}
