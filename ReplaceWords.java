package org.example;
// Time Complexity : O(m*l)  ->m is the number of words  & l is the length of each word
// Space Complexity : O(m*l)
// Did this code successfully run on Leetcode : Yes
import java.util.List;

public class ReplaceWords {

    TrieNode root;
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode()
        {
            this.children = new TrieNode[26];
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        insert(root,dictionary);  //O(m*l)
        String[] splittedSentence = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i=0; i<splittedSentence.length; i++)
        {
            if(i>0)
            {
                result.append(" ");
            }
            String temp = search(root,splittedSentence[i]);
            result.append(temp);
        }
        return result.toString();
    }

    public String search(TrieNode root, String word)
    {
        TrieNode curr = root;
        StringBuilder replacedString = new StringBuilder();
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null || curr.isEnd)
            {
                break;
            }else{
                replacedString.append(c);
                curr = curr.children[c-'a'];
            }
        }
        if(curr.isEnd)
            return replacedString.toString();
        else
            return word;
    }

    public void insert(TrieNode root, List<String> dictionary)
    {
        TrieNode curr = root;
        for(int i=0; i<dictionary.size(); i++)
        {
            String word = dictionary.get(i);
            for(int j=0; j<word.length();j++)
            {
                char c = word.charAt(j);
                if(curr.children[c-'a']==null)
                {
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
            curr = root;
        }
    }
}
