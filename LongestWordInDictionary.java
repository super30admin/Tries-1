/**
 * Time complexity : O(n)  for inserting and searching one word
 * Space complexity : O(n)  where n = number of words stored in the trie
 */
public class LongestWordInDictionary {
    TrieNode root;
    String max = "";
    int maxlen = 0;
    public String longestWord(String[] words) {
        if(words == null || words.length == 0) return "";
        
        root = new TrieNode();
        
        for(String str : words)
        {
            insertIntoTrie(str);
        }
        
        dfsTrie(root,0);
        
        return max;
        
        
        
        
        
    }
    
    public void insertIntoTrie(String str)
    {
        TrieNode temp = root;
        for(int i = 0 ; i < str.length() ; i ++)
        {
            if(temp.children[str.charAt(i) - 'a'] == null)
            {
                temp.children[str.charAt(i) - 'a'] = new TrieNode();
            }
            temp = temp.children[str.charAt(i) - 'a'];
        }
        temp.word = str;
    }
    
    public void dfsTrie(TrieNode root,int level)
    {
        if(root == null) return;
        
        if(level!=0 && root.word == null)
        {
            return;
        }
        
        if(root.word!=null)
        {
            if(root.word.length() == maxlen)
            {
                if(root.word.compareTo(max)<0)
                {
                    max = root.word;
                    maxlen = root.word.length();
                }
                    
            }
            else if(root.word.length()>maxlen)
            {
                max = root.word;
                maxlen = root.word.length();
            }
        }
        else
        {
            
        }
        
    
        for(int i = 0 ; i < 26 ; i ++)
        {
            dfsTrie(root.children[i],level+1);
        }
        
    }
    
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