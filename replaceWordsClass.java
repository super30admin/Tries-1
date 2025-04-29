// Time Complexity :  O(N  + M) where N = number of dictionary words , M = number of words in the sentence
// Space Complexity : O(N) for storing all dictionary words in Trie
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

// Approach : 
// Insert all dictionary root words into a Trie.
// For each word in the sentence, try to replace it with the shortest matching root.
// Build the final sentence using replaced or original words.


import java.util.*;

class replaceWordsClass {
    public class Trie 
    {
        Trie[] children =new Trie[26];
        boolean present =false;
    }
    Trie trie = new Trie();
    public void add(String word)
    {
        Trie dup = trie;
        char[] ch = word.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            int x = ch[i] - 'a';
            if(dup.children[x] == null)
            {
                dup.children[x] = new Trie();
            }
            dup = dup.children[x];
        }
        dup.present = true;
    }
    public String check(String word)
    {
        Trie dup = trie;
        char[] ch = word.toCharArray();
        StringBuilder send = new StringBuilder();
        for(int i=0;i<ch.length;i++)
        {
            int x = ch[i] - 'a';
            if(dup.children[x] == null)
            {
                return word;
            }
            else
            {
                send = send.append(ch[i]);
            }
            dup = dup.children[x];
            if(dup.present)
            {
                return send.toString();
            }
        }
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) 
    {
        StringBuilder op = new StringBuilder();
        String[] rep = sentence.split(" ");
        for(int i=0;i<dictionary.size();i++)
        {
            add(dictionary.get(i));
        } 
        for(int i=0;i<rep.length;i++)
        {
            op.append(check(rep[i]));
            if(i!=rep.length-1)
            {
                op.append(" ");
            }
        }  
        return op.toString();
    }
}