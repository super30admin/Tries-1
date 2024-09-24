import java.util.LinkedList;
import java.util.Queue;
class Solution {
    class TrieNode{
        TrieNode[] children;
        String isEnd;
        public TrieNode()
        {
            children= new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word)
    {
        TrieNode curr= root;
        for(int i=0; i<word.length(); i++)
        {
            char c= word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a']= new TrieNode();
            }
            curr= curr.children[c-'a'];
        }
        curr.isEnd= word;
    }
    
        public String longestWord(String[] words) {
            if(words==null || words.length==0)
            {
                return "";
            }
            root= new TrieNode();
            for (String word: words)
            {
                insert(word);
            }
            Queue<TrieNode> q= new LinkedList<>();
            q.add(root);
            TrieNode curr= root;
            while(!q.isEmpty())
            {
                 curr= q.poll();
                 for(int i=25;i>=0;i--)
                 {
                    if(curr.children[i]!=null && curr.children[i].isEnd!=null)
                    {
                        q.add(curr.children[i]);
    
                    }
                 }
            }
            if(curr.isEnd==null)
            {
                return "";
            }
            return curr.isEnd;
        }
    }