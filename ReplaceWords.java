/**
 * Time Complexity : O(N+L) where N = number of words in sentence L =  number of words we need to enter into trie
 * Space Complexity : O(N) where N = number of words we need to enter into the trie
 */

import java.util.*;
public class ReplaceWords {
    TrieNode root;
    String out = "";
    public String replaceWords(List<String> dict, String sentence) {
        
        root = new TrieNode();
        for(String str : dict)
        {
            insertIntoTrie(str);
        }
        
        String[] words = sentence.split("\\s+");
        for(int i = 0 ; i < words.length ; i ++)
        {
            String word = words[i];
            TrieNode temp = root;
            String replace = "";
            for(int j = 0; j < word.length() ; j ++)
            {
                char c = word.charAt(j);
                if(temp.children[c - 'a'] == null || temp.word != null) break;
                temp = temp.children[c - 'a'];
            }
            if(temp.word == null)
            {
                replace = word;
            }
            else
            {
                replace = temp.word;
            }
            out = out + replace + " ";
            

        }
        
        //System.out.println(out);
        
        return out.substring(0,out.length()-1);
        
    }
    
    
    public void insertIntoTrie(String word)
    {
        TrieNode temp = root;
        for(int i = 0 ; i < word.length() ;i++)
        {
            if(temp.children[word.charAt(i) - 'a'] == null)
            {
                temp.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            temp = temp.children[word.charAt(i) - 'a'];
        }
        temp.word = word;
    }
    
    
    
    class TrieNode
    {
        String word;
        TrieNode[] children;
        TrieNode()
        {
            word = null;
            children = new TrieNode[26];
        }
    }
}
