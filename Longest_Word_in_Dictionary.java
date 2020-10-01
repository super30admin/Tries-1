//Time Complexity-O(n)
//Space Complexity-O(n)// where n is number of character in words
class Solution {
    public class TrieNode{
        TrieNode[] children;
        String word;
        TrieNode()
        {
            children=new TrieNode[26];
            word=" ";
        }
    }
    private TrieNode root=new TrieNode();
    public String longestWord(String[] words) {
        CreateTrie(words);
        DFS(root);
        return result;
    }
    private void CreateTrie(String[] words)
    {
        for(String word:words)
        {
            TrieNode cur=root;
            for(Character c:word.toCharArray())
            {
                if(cur.children[c-'a']==null)
                {
                    cur.children[c-'a']=new TrieNode();
                }
                cur=cur.children[c-'a'];
            }
            cur.word=word;
        }        
    }
    String result="";
    private void DFS(TrieNode root)
    {       
        if(root.word.length()>result.length())
        {
            result=root.word;
        }
        for(int i=0;i<26;i++)
        {
            if(root.children[i]!=null &&root.children[i].word!=" ")
            {
                DFS(root.children[i]);
            }
        }
    }


}