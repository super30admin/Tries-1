//Time:
//Insert:O(n)
//Search:O(words * average length of words)
//https://leetcode.com/submissions/detail/632634582/

public class Solution {
    class TrieNode {

        public TrieNode[] Children {get; set;}
        public bool IsEnd{get; set;}

        public TrieNode() {
            Children = new TrieNode[26];
        }            
    }
    
    TrieNode root;
    
    public Solution (){
        root = new TrieNode();
    }
    
    public void Insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.Length; i++)
        {
            char c = word[i];
            if (curr.Children[c - 'a'] == null)
            {
                curr.Children[c - 'a'] = new TrieNode();
            }
            curr = curr.Children[c - 'a'];
        }
        curr.IsEnd = true;
    }
    
    public string Search(string word) {
        
        TrieNode curr = root;
        string replacement = "";
        for (int i = 0; i < word.Length; i++)
        {
            char c = word[i];
            if (curr.IsEnd == true)
            {
                return replacement;
            }
            if (curr.Children[c - 'a'] == null)
            {
                return null;
            }
            else
            {
                replacement += c;
            }
            curr = curr.Children[c - 'a'];
        }
        return null;
    }
    
    public string ReplaceWords(IList<string> dictionary, string sentence) {
        
        foreach (String word in dictionary)
        {
            Insert(word);
        }
        string result = "";
        string[] subs = sentence.Split(' ');
        foreach (string s in subs)
        {
            string replacement = Search(s);
            if (replacement != null)
            {
                result += replacement + " ";
            }
            else
            {
                result += s + " ";
            }

        }
        result = result.TrimEnd();
        return result;
    }
}