package s30Coding;
import java.util.*;

//Time Complexity :- length of the word * total number of words
//Space Complexity :- length of the word * total number of words

public class LongestWordInDictionary {
	TrieNode root=new TrieNode();
    class TrieNode {
        String word;
        TrieNode[] children;
        TrieNode() {
            children=new TrieNode[26];
        }
    }
    public String longestWord(String[] words) {
        for(String s: words)
        {
            insert(s);
        }
        
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode node=null ;
        while(!q.isEmpty())
        {
            node=q.poll();
            for(int i=25; i>=0; i--)
            {
                if(node.children[i] != null && node.children[i].word!=null)
                {
                    q.add(node.children[i]);
                }
            }
        }
        return node.word;
        
    }
    
    public void insert(String word)
    {
        TrieNode curr=root;
        for(int i=0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.word=word;
    }
}
